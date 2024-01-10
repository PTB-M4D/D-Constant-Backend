/*
 * Copyright (c) 2022-2023 Physikalisch-Technische Bundesanstalt (PTB), all rights reserved.
 * This source code and software is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, version 3 of the License.
 * The software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this XSD. If not, see http://www.gnu.org/licenses.
 * CONTACT: info@ptb.de
 * DEVELOPMENT: https://d-si.ptb.de
 * AUTHORS: Wafa El Jaoua, Tobias Hoffmann, Clifford Brown, Daniel Hutzschenreuter
 * LAST MODIFIED: 15.09.23, 16:57
 */

package de.ptb.codataapi.security;


import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@EnableMethodSecurity
@EnableWebMvc
@EnableWebSecurity
@Configuration
public class SecurityFilterChain implements WebMvcConfigurer {


    @Bean
    public DefaultSecurityFilterChain insecureFilterChain(HttpSecurity http) {

        log.warn("Es werden aktuell alle Requests unautorisiert durchgelassen. Bitte nur zu Entwicklungszwecken verwenden.");
        DefaultSecurityFilterChain chain = null;
        RequestMatcher apiV1Matcher = new RegexRequestMatcher("/api/d-constant/([\\S\\s]*?)", null);


        try {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .cors(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(requestsCustomizer ->
                            requestsCustomizer
                                    .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", " /api/d-constant/swagger-ui/**", "/swagger-resources/**",
                                            "/swagger-ui.html").permitAll()
                                    .requestMatchers(apiV1Matcher).permitAll()
                                    .anyRequest().permitAll());
            chain = http.build();
        } catch (Exception e) {
            log.warn("Unable to configure http security", e);
        }
        log.trace("insecurefilterChain(HttpSecurity)::end");
        return chain;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
        registry.addResourceHandler("swagger-initializer.js").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
        registry.addResourceHandler("swagger-ui.css").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
        registry.addResourceHandler("swagger-ui-bundle.js").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
        registry.addResourceHandler("index.css").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
        registry.addResourceHandler("swagger-ui-standalone-preset.js").addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
        // Make Swagger meta-data available via <baseURL>/v2/api-docs/
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // Make Swagger UI available via <baseURL>/swagger-ui.html
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
     }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers( "/api/d-constant/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui/**", "/resources/**", "/webjars/**",
                "**/swagger-ui-standalone-preset.js", "**/index.css", "**/swagger-ui-bundle.js", "**/swagger-ui.css", "**/swagger-initializer.js", "/favicon.ico");
    }

    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }
}

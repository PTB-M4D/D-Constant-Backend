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
 * along with this code. If not, see http://www.gnu.org/licenses.
 * CONTACT: info@ptb.de
 * DEVELOPMENT: https://d-si.ptb.de
 * AUTHORS: Wafa El Jaoua, Tobias Hoffmann, Clifford Brown, Daniel Hutzschenreuter
 * LAST MODIFIED: 21.06.23, 10:39
 */

package de.ptb.codataapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class CorsConfig {
    /**
     * Defines a CORS (Cross-Origin Resource Sharing) configuration for the Spring Web application.
     * @return A {@link WebMvcConfigurer} instance representing the CORS configuration.
     * @author Wafa El jaoua
     * @version 0.1
     */
    @Bean
    public WebMvcConfigurer corsConfigurer()  {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Map to all endpoints.
                        .allowedOrigins("http://localhost:4200","http://localhost:8083/api",
                                "https://d-si.ptb.de","https://d-si.ptb.de/api/d-siConstantJson",
                                "https://d-si.ptb.de/api/d-constant/swagger-ui/index.html") //list of allowed origin URLs.
                        .allowedMethods("GET","POST","PUT","DELETE")// Allowed HTTP methods.
                        .allowedHeaders("*")// Allowed request headers.
                        .exposedHeaders("header1", "header2")// Headers that can be exposed to the client.
                        .allowCredentials(false).// Whether credentials (e.g., cookies) are allowed to be sent.
                        maxAge(3600);// Maximum time for which the CORS configuration is cached.
            }
        };
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(List.of("http://localhost:8082","https://d-si.ptb.de"));
//        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
//        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
//        config.setAllowCredentials(true);
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
}

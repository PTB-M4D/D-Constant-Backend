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
 * LAST MODIFIED: 07.06.23, 16:04
 */

package de.ptb.codataapi;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@OpenAPIDefinition(servers = {
//        @Server(url = "http://localhost:8082", description = "local testing api"),
//        @Server(url = "https://d-si.ptb.de", description = "production system")})
//@Tag(name = "D-Constant Api", description = "D-Constant management APIs")
@SpringBootApplication

public class CodataApiApplication  {

    public static void main(String[] args){
        SpringApplication.run(CodataApiApplication.class, args);

        }

}

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
 * LAST MODIFIED: 29.05.23, 09:53
 */

package de.ptb.codataapi.repository;

import de.ptb.codataapi.model.ScientificConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
/**
 * This is an interface for scientific constant repository to find ScientificConstant By Name and Year
 * @author Wafa El jaoua
 * @version 0.1
 */
public interface ScientificConstantRepository extends JpaRepository<ScientificConstant,Long> {
    ScientificConstant findScientificConstantByNameYear(String nameYear);

}

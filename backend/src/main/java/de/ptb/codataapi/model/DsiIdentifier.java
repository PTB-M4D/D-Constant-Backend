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
 * LAST MODIFIED: 05.06.23, 11:37
 */

package de.ptb.codataapi.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
/**
 * Entity for dsi identifier
 * @author Wafa El jaoua
 * @version 0.1
 */
@Entity
@Table(name = "dsiidentifier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DsiIdentifier implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;
    @XmlElement ( namespace = "http://purl.org/dc/terms/")
    private String publisher;
    @XmlElement ( namespace = "http://purl.org/dc/terms/" )
    private String identifier;
}

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
 * LAST MODIFIED: 14.06.23, 14:07
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
 * Entity for dsi constant
 * @author Wafa El jaoua
 * @version 0.1
 */
@Entity
@Table(name = "dsiconstant")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class DsiConstant  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;
    @XmlTransient
    private String year;
    @XmlElement( namespace = "https://ptb.de/si")
    private String label;
    @XmlElement( namespace = "https://ptb.de/si")
    private String quantityTypeQUDT;
    @XmlElement( namespace = "https://ptb.de/si")
    private String value;
    @XmlElement( namespace = "https://ptb.de/si")
    private String unit;
    @XmlElement( namespace = "https://ptb.de/si")
    //@XmlJavaTypeAdapter(DateTimeAdapter.class)
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private String dateTime;
    @XmlElement( namespace = "https://ptb.de/si")
    private String uncertainty;
    @XmlElement( namespace = "https://ptb.de/si")
    private String distribution;

}

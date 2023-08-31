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
 * LAST MODIFIED: 13.06.23, 15:38
 */

package de.ptb.codataapi.model;

import de.ptb.codataapi.marshal.RootElementProvider;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.util.List;

/**
 * Entity for scientific constant
 * @author Wafa El jaoua
 * @version 0.1
 */
@Entity
@Data
@Table(name = "scientificConstant")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name= "constant", namespace = "https://ptb.de/si/d-constant" )
@XmlAccessorType(XmlAccessType.FIELD)
public class ScientificConstant implements RootElementProvider {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;
    @XmlTransient
    private  String name;
    @XmlTransient
    private  String year;
    @Formula("concat(name,year)")
    @XmlTransient
    private String nameYear;
    @OneToMany
    @XmlElementWrapper(name="identifiers", namespace = "https://ptb.de/si/d-constant")
    @XmlElement( namespace = "https://ptb.de/si/d-constant" )
    private List<DsiIdentifier> identifier;
    @XmlElement( namespace = "https://ptb.de/si/d-constant" )
    private boolean dsiApproved;
    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name="constant", namespace = "https://ptb.de/si" )
    private DsiConstant dsiConstant;
    @XmlAttribute
    private boolean isSIDefining;
    @XmlAttribute
    private boolean isCOData;
    @XmlAttribute
    private boolean isMath;

    @Override
    public String getRootElementName(String nameYear) {
        return "dsi:" + nameYear;
    }
}

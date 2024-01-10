/*
 * Copyright (c) 2022-2024 Physikalisch-Technische Bundesanstalt (PTB), all rights reserved.
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
 * LAST MODIFIED: 02.01.24, 21:30
 */

package de.ptb.codataapi.service;

import de.ptb.codataapi.model.RootElementProvider;

import de.ptb.codataapi.model.ScientificConstant;
import de.ptb.codataapi.repository.ScientificConstantRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ScientificConstantService {
    private final ScientificConstantRepository scientificConstantRepository;


    public List<ScientificConstant> getScientificConstantList() {
        return scientificConstantRepository.findAll();
    }
    public  String getConstantByNameSubName(String name) throws JAXBException {
        if(name==null){
            throw new NullPointerException("The constant should be not null");
        }
        ScientificConstant constant = scientificConstantRepository.findScientificConstantByNameYear(name);
        String xml = marshal(constant,name);
        return xml;
    }
    public  String marshal(ScientificConstant scientificConstant, String name) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(scientificConstant.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "https://ptb.de/si/d-constant constantDataType.xsd");
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");

        StringWriter writer = new StringWriter();
        QName rootElementName = new QName(((RootElementProvider) scientificConstant).getRootElementName(name));
        JAXBElement<ScientificConstant> jaxbElement = new JAXBElement<>(rootElementName, ScientificConstant.class, scientificConstant);
        marshaller.marshal(jaxbElement, writer);
        return writer.toString();
    }

}

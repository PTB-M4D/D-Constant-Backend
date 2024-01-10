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
 * LAST MODIFIED: 02.01.24, 21:45
 */

package de.ptb.codataapi.service;

import de.ptb.codataapi.model.DsiConstant;
import de.ptb.codataapi.model.DsiIdentifier;
import de.ptb.codataapi.model.ScientificConstant;
import de.ptb.codataapi.repository.DsiIdentifierRepository;
import de.ptb.codataapi.repository.ScientificConstantRepository;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ScientificConstantServiceTest {
    @InjectMocks
    private ScientificConstantService scientificConstantService;
    @Mock
    ScientificConstantRepository scientificConstantRepository;
    @Mock
    DsiIdentifierRepository dsiIdentifierRepository;
    private ScientificConstant planckConstant2018;
    private DsiIdentifier dsi01, dsi02, dsi03, dsi04;
    private String xml;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        List<DsiIdentifier> dsiIdentifierList0 = new ArrayList<>();
        dsi01 = new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/planckConstant2018");
        dsi02 = new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/codata/planckConstant");
        dsi03 = new DsiIdentifier(null, "BIPM", "https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        dsi04 = new DsiIdentifier(null, "CODATA", "https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        dsiIdentifierList0.add(dsi01);
        dsiIdentifierList0.add(dsi02);
        dsiIdentifierList0.add(dsi03);
        dsiIdentifierList0.add(dsi04);
        dsiIdentifierRepository.save(dsi01);
        dsiIdentifierRepository.save(dsi02);
        dsiIdentifierRepository.save(dsi03);
        dsiIdentifierRepository.save(dsi04);

        DsiConstant constant = new DsiConstant(null,
                "2018",
                "planckConstant",
                "Action",
                "6.62607015E-34",
                "\\joule\\hertz\\tothe{-1}",
                "2018-05-20T00:00:00Z",
                "0.0",
                "normal");

        planckConstant2018 = new ScientificConstant(null,
                "planckConstant",
                "2018",
                "planckConstant2018",
                dsiIdentifierList0,
                true,
                constant,
                true,
                true,
                false);
        scientificConstantRepository.save(planckConstant2018);
        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<dsi:planckConstant2018 isSIDefining=\"true\" isCOData=\"true\" isMath=\"false\" xsi:schemaLocation=\"https://ptb.de/si/d-constant constantDataType.xsd\" xmlns:si=\"https://ptb.de/si\" xmlns:dcterms=\"http://purl.org/dc/terms/\" xmlns:dsi=\"https://ptb.de/si/d-constant\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <dsi:identifiers>\n" +
                "        <dsi:identifier>\n" +
                "            <dcterms:publisher>DSI</dcterms:publisher>\n" +
                "            <dcterms:identifier>https://ptb.de/si/d-constant/planckConstant2018</dcterms:identifier>\n" +
                "        </dsi:identifier>\n" +
                "        <dsi:identifier>\n" +
                "            <dcterms:publisher>DSI</dcterms:publisher>\n" +
                "            <dcterms:identifier>https://ptb.de/si/d-constant/codata/planckConstant</dcterms:identifier>\n" +
                "        </dsi:identifier>\n" +
                "        <dsi:identifier>\n" +
                "            <dcterms:publisher>BIPM</dcterms:publisher>\n" +
                "            <dcterms:identifier>https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant</dcterms:identifier>\n" +
                "        </dsi:identifier>\n" +
                "        <dsi:identifier>\n" +
                "            <dcterms:publisher>CODATA</dcterms:publisher>\n" +
                "            <dcterms:identifier>https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant</dcterms:identifier>\n" +
                "        </dsi:identifier>\n" +
                "    </dsi:identifiers>\n" +
                "    <dsi:dsiApproved>true</dsi:dsiApproved>\n" +
                "    <si:constant>\n" +
                "        <si:label>planckConstant</si:label>\n" +
                "        <si:quantityTypeQUDT>Action</si:quantityTypeQUDT>\n" +
                "        <si:value>6.62607015E-34</si:value>\n" +
                "        <si:unit>\\joule\\hertz\\tothe{-1}</si:unit>\n" +
                "        <si:dateTime>2018-05-20T00:00:00Z</si:dateTime>\n" +
                "        <si:uncertainty>0.0</si:uncertainty>\n" +
                "        <si:distribution>normal</si:distribution>\n" +
                "    </si:constant>\n" +
                "</dsi:planckConstant2018>\n";
    }

    @Test
    public void should_marshal_byName() throws JAXBException {
        //given
        String name = "planckConstant2018";
        // when
        String expected = scientificConstantService.marshal(planckConstant2018, name);
        //then
        assertEquals(xml, expected);
        Mockito.verify(dsiIdentifierRepository, Mockito.times(1)).save(dsi01);
        Mockito.verify(scientificConstantRepository, Mockito.times(1)).save(planckConstant2018);
    }

    @Test
    public void should_getConstant_by_name_subname() throws JAXBException {
        //given
        String name = "planckConstant2018";
        //Mock the call
        Mockito.when(scientificConstantRepository.findScientificConstantByNameYear(name)).thenReturn(planckConstant2018);
        //when
        String expected = scientificConstantService.getConstantByNameSubName(name);
        //then
        assertEquals(xml, expected);
    }

    @Test
    public void should_throw_NullPointer_exception_when_constant_null() throws JAXBException {
        //given
        var exception = assertThrows(NullPointerException.class, () -> scientificConstantService.getConstantByNameSubName(null));
        //when
        String message = exception.getMessage();
        //then
        assertEquals(message, "The constant should be not null");
    }
}
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
 * LAST MODIFIED: 04.01.24, 11:19
 */

package de.ptb.codataapi.controller;

import de.ptb.codataapi.model.DsiConstant;
import de.ptb.codataapi.model.DsiIdentifier;
import de.ptb.codataapi.model.ScientificConstant;
import de.ptb.codataapi.service.ScientificConstantService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class ScientificConstantControllerTest {
    @Mock
    private ScientificConstantService scientificConstantService;
    @InjectMocks
    private ScientificConstantController constantController;
    List <ScientificConstant> constantList;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setup(){
        constantList=Arrays.asList(new ScientificConstant(1L,
                "planckConstant",
                "2016",
                "planckConstant2016",
                List.of(new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/planckConstant2016")),
                true,
                new DsiConstant(null,
                        "2016",
                        "planckConstant",
                        "Action",
                        "6.62607015E-34",
                        "\\joule\\hertz\\tothe{-1}",
                        "2018-05-20T00:00:00Z",
                        "0.0",
                        "normal"),
                true,
                true,
                false));
        mockMvc = MockMvcBuilders.standaloneSetup(constantController).build();
    }
    @AfterEach
    void tearDown() {
       constantList = null;
    }
    @Test
    public void GetMappingOfConstantList() throws Exception {
        when(scientificConstantService.getScientificConstantList()).thenReturn(constantList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/d-constantJson").
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                . andDo(MockMvcResultHandlers.print());
        verify(scientificConstantService).getScientificConstantList();
        verify(scientificConstantService,times(1)).getScientificConstantList();
    }
    @Test
    public void should_getConstant_by_name_subname() throws Exception {
        //given
        String name = "planckConstant2018";
        //when
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
        when(scientificConstantService.getConstantByNameSubName(name)).thenReturn(xml);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/d-constant/"+name)
                        .contentType(MediaType.APPLICATION_XML_VALUE))
                        .andExpect(status().isOk())
                        .andDo(MockMvcResultHandlers.print());
        verify(scientificConstantService).getConstantByNameSubName(name);
        verify(scientificConstantService,times(1)).getConstantByNameSubName(name);
    }
}
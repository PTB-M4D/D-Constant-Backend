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
 * LAST MODIFIED: 22.08.23, 11:18
 */

package de.ptb.codataapi.controller;


import de.ptb.codataapi.marshal.XmlMarshaller;
import de.ptb.codataapi.model.*;
import de.ptb.codataapi.repository.DsiConstantRepository;
import de.ptb.codataapi.repository.ScientificConstantRepository;
import de.ptb.codataapi.service.DccValidationServiceImpl;
import jakarta.xml.bind.JAXBException;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api")
public class ServiceController {

    private ScientificConstantRepository scientificConstantRepository;
    private DsiConstantRepository dsiConstantRepository;

    private DccValidationServiceImpl dccService;
    private static final  String VALID_DCC="PTB-DCC-4711";

    /**
     * method to get List of ScientificConstant
     * @return List<ScientificConstant> in JSON format.
     * @author Wafa El jaoua
     * @version 0.1
     */
    @GetMapping(value = "/d-constantJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScientificConstant> getScientificConstantsJson() {
        return scientificConstantRepository.findAll();
    }
    /**
     * method to get List of DsiConstant
     * @return List<DsiConstant>
     */
    @GetMapping(value = "/d-siConstantJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DsiConstant> getSiConstantsJson() {
        return dsiConstantRepository.findAll();
    }

    /**
     * Retrieves a ScientificConstant object by its name using a GET request.
     * @param name of fundamental physical constant
     * @return constant  in JSON format
     */
    @GetMapping(value = "/d-constantJson/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ScientificConstant getScientificConstantsByNameYearJson(@PathVariable String name) {
        return scientificConstantRepository.findScientificConstantByNameYear(name);
    }
    /**
     *  GET request that gets the ID of a constant and returns the XML with the data of the constant.
     * @param name of fundamental physical constant
     * @return constant in XML format
     */
    @GetMapping(value = "/d-constant/{name}", produces = MediaType.APPLICATION_XML_VALUE)
    public  ResponseEntity<String> marshal(@PathVariable String name) throws JAXBException {
        ScientificConstant constant = scientificConstantRepository.findScientificConstantByNameYear(name);
        String xml = XmlMarshaller.marshal(constant,name);
        return new ResponseEntity<>(xml, HttpStatus.OK);
    }

    /********************************************************************************/
    /*                          DPP-Backend                                         */
    /********************************************************************************/
    /**
     * DCC Validation for DPP
     * @param dccPid
     * @return boolean dccPid valid or invalid
     */

    @GetMapping(value = "dccValidation/{dccPid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getDPPByDcc(@PathVariable  String dccPid) {
        return  ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("valid_dcc",dccService.validate(dccPid,VALID_DCC)));
    }

}

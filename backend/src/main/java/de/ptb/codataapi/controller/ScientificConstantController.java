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

import de.ptb.codataapi.model.*;

import de.ptb.codataapi.repository.DsiConstantRepository;
import de.ptb.codataapi.service.DccValidationServiceImpl;
import de.ptb.codataapi.service.ScientificConstantService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

//@Tag(name = "D-Constant-Api", description = " management API")
//
//@OpenAPIDefinition(servers = {
//        @Server(url = "http://localhost:8082", description = "production system"),
//        @Server(url = "https://d-si.ptb.de", description = "local api")
//})
@RestController
@RequestMapping(path = "/api")
@Profile({"swagger"})

@RequiredArgsConstructor
public class ScientificConstantController {

    private final ScientificConstantService scientificConstantService;
    private final DccValidationServiceImpl dccService;
    private final DsiConstantRepository dsiConstantRepository;
    private static final  String VALID_DCC="PTB-DCC-4711";


    /**
     *  GET request that gets  a constant by name and subname and returns the XML with the data of the constant.
     * @param name of fundamental physical constant
     * @return constant in XML format
     */
    @Operation(
            summary = "Retrieve a physical constant by name and subName",
            description = "Get a physical constant  by specifying its name and subName. The response is D-si Xml",
            tags = { "d-constant" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ScientificConstant.class), mediaType = "application/XML") }),
            @ApiResponse(responseCode = "404", description = "The constant with given name and subName was not found.", content = { @Content(schema = @Schema()) })
    })
    @GetMapping(value = "/d-constant/{name}", produces = MediaType.APPLICATION_XML_VALUE)
    public  ResponseEntity<String> getConstantByNameSubName(@PathVariable String name) throws JAXBException {
        String xml = scientificConstantService.getConstantByNameSubName(name);
        return new ResponseEntity<>(xml, HttpStatus.OK);
    }
    /**
     * method to get List of ScientificConstant
     * @return List<ScientificConstant> in JSON format.
     * @author Wafa El jaoua
     * @version 0.1
     */
    @Hidden
    @GetMapping(value = "/d-constantJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScientificConstant> getScientificConstantsJson() {
        return scientificConstantService.getScientificConstantList();
    }

    /********************************************************************************/
    /*                          DPP-Backend                                         */
    /********************************************************************************/
    /**
     * DCC Validation for DPP
     * @param dccPid
     * @return boolean dccPid valid or invalid
     */

    // TO DO: Test(Unit&&Integration)
    @GetMapping(value = "dccValidation/{dccPid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Hidden
    public ResponseEntity<Object> getDPPByDcc(@PathVariable  String dccPid) {
        return  ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("valid_dcc",dccService.validate(dccPid,VALID_DCC)));
    }

    /**
     * method to get List of DsiConstant
     * @return List<DsiConstant>
     */
    @GetMapping(value = "/d-siConstantJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DsiConstant> getSiConstantsJson() {
        return dsiConstantRepository.findAll();
    }



//    private final ScientificConstantRepository scientificConstantRepository;
//    private final DsiConstantRepository dsiConstantRepository;
//    /**
//     * Retrieves a ScientificConstant object by its name using a GET request.
//     * @param name of fundamental physical constant
//     * @return constant  in JSON format
//     */
//    @Hidden
//    @GetMapping(value = "/d-constantJson/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ScientificConstant getScientificConstantsByNameYearJson(@PathVariable String name) {
//        return scientificConstantRepository.findScientificConstantByNameYear(name);
//    }

//    @Operation(
//            summary = "Retrieve a list of physical and mathematical constants ",
//            description = "Get a list of physical and mathematical constants with data (value,unit, dateTime,uncertainty....). The response is JSON data",
//            tags = { "d-constant"})
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DsiConstant.class), mediaType = "application/JSON") }),
//            @ApiResponse(responseCode = "404", description = "The constant with given name and subName was not found.", content = { @Content(schema = @Schema()) })
//    })


}

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
 * LAST MODIFIED: 26.06.23, 09:40
 */

package de.ptb.codataapi.database;

import de.ptb.codataapi.model.DsiConstant;
import de.ptb.codataapi.model.DsiIdentifier;
import de.ptb.codataapi.model.ScientificConstant;
import de.ptb.codataapi.repository.DsiConstantRepository;
import de.ptb.codataapi.repository.DsiIdentifierRepository;
import de.ptb.codataapi.repository.ScientificConstantRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseUpdate implements CommandLineRunner {
    private DsiIdentifierRepository dsiIdentifierRepository;
    private ScientificConstantRepository scientificConstantRepository;

    /**
     * method to fill database wit physical constant data
     * @param args
     * @throws Exception
     * @author Wafa El jaoua
     * @version 0.1
     */
    @Override
    public void run(String... args) throws Exception {


        /********************************************************************************/
        /*                          planckConstant 2018                                  */
        /********************************************************************************/
        ScientificConstant planckConstant2018 = new ScientificConstant();
        planckConstant2018.setName("planckConstant");
        planckConstant2018.setYear("2018");
        planckConstant2018.setDsiApproved(true);
        planckConstant2018.setIdentifier(dsiIdentifierRepository.findAll());
        planckConstant2018.setDsiConstant(new DsiConstant(null,"2018", "planckConstant", "Action", "6.62607015E-34", "\\joule\\hertz\\tothe{-1}", "2018-05-20T00:00:00Z" , "0.0", "normal"));
        planckConstant2018.setMath(false);
        planckConstant2018.setSIDefining(true);
        planckConstant2018.setCOData(true);

        List <DsiIdentifier> dsiIdentifierList0 = new ArrayList<>();
        DsiIdentifier dsi01 = new DsiIdentifier(null,"DSI","https://ptb.de/si/d-constant/planckConstant2018");
        DsiIdentifier dsi02 = new DsiIdentifier(null,"DSI","https://ptb.de/si/d-constant/codata/planckConstant");
        DsiIdentifier dsi03 = new DsiIdentifier(null,"BIPM","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        DsiIdentifier dsi04 = new DsiIdentifier(null,"CODATA","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        dsiIdentifierList0.add(dsi01);
        dsiIdentifierList0.add(dsi02);
        dsiIdentifierList0.add(dsi03);
        dsiIdentifierList0.add(dsi04);
        dsiIdentifierRepository.save(dsi01);
        dsiIdentifierRepository.save(dsi02);
        dsiIdentifierRepository.save(dsi03);
        dsiIdentifierRepository.save(dsi04);
        planckConstant2018.setIdentifier( dsiIdentifierList0);
        scientificConstantRepository.save(planckConstant2018);

        /********************************************************************************/
        /*                          planckConstant 2014                                  */
        /********************************************************************************/
        ScientificConstant planckConstant2014 = new ScientificConstant();
        planckConstant2014.setName("planckConstant");
        planckConstant2014.setYear("2014");
        planckConstant2014.setDsiApproved(true);
        planckConstant2014.setDsiConstant(new DsiConstant(null,"2014" ,"planckConstant", "Action", "6.626070040E-34", "\\joule\\second", "2015-06-25T00:00:00Z" , "0.000000081E-34", "normal"));
        planckConstant2014.setMath(false);
        planckConstant2014.setSIDefining(false);
        planckConstant2014.setCOData(true);

        List <DsiIdentifier> dsiIdentifierList = new ArrayList<>();
        DsiIdentifier dsi1 = new DsiIdentifier(null,"DSI","https://ptb.de/si/d-constant/planckConstant2014");
        DsiIdentifier dsi2 = new DsiIdentifier(null,"DSI","https://ptb.de/si/d-constant/codata/planckConstant");
        DsiIdentifier dsi3 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cuu/pdf/all_2014.pdf");
        dsiIdentifierList.add(dsi1);
        dsiIdentifierList.add(dsi2);
        dsiIdentifierList.add(dsi3);
        dsiIdentifierRepository.save(dsi1);
        dsiIdentifierRepository.save(dsi2);
        dsiIdentifierRepository.save(dsi3);
        planckConstant2014.setIdentifier( dsiIdentifierList);
        scientificConstantRepository.save(planckConstant2014 );
        /********************************************************************************/
        /*                          speedOfLightInVacuum 2018                                    */
        /********************************************************************************/
        ScientificConstant speedOfLight2018 = new ScientificConstant();
        speedOfLight2018.setName("speedOfLightInVacuum");
        speedOfLight2018.setYear("2018");
        speedOfLight2018.setDsiApproved(true);
        speedOfLight2018.setDsiConstant(new DsiConstant(null,"2018" ,"speedOfLightInVacuum", "Speed", "299792458.0", "\\metre\\second\\tothe{-1}", "2019-05-20T00:00:00Z" , "0.0", "normal"));
        speedOfLight2018.setMath(false);
        speedOfLight2018.setSIDefining(true);
        speedOfLight2018.setCOData(true);

        List <DsiIdentifier> dsiIdentifierList18 = new ArrayList<>();
        DsiIdentifier dsi18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/speedOfLightInVacuum2018");
        DsiIdentifier dsi28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/speedOfLightInVacuum");
        DsiIdentifier dsi38 = new DsiIdentifier(null,"BIPM","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/speed_of_light_vacuum");
        DsiIdentifier dsi48 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?c|search_for=speed+of+light");
        dsiIdentifierList18.add(dsi18);
        dsiIdentifierList18.add(dsi28);
        dsiIdentifierList18.add(dsi38);
        dsiIdentifierList18.add(dsi48);
        dsiIdentifierRepository.save(dsi18);
        dsiIdentifierRepository.save(dsi28);
        dsiIdentifierRepository.save(dsi38);
        dsiIdentifierRepository.save(dsi48);
        speedOfLight2018.setIdentifier(dsiIdentifierList18);
        scientificConstantRepository.save(speedOfLight2018);

        /********************************************************************************/
        /*                          speedOfLightInVacuum 2014                           */
        /********************************************************************************/
        ScientificConstant speedOfLight2014 = new ScientificConstant();
        speedOfLight2014.setName("speedOfLightInVacuum");
        speedOfLight2014.setYear("2014");
        speedOfLight2014.setDsiApproved(true);
        speedOfLight2014.setDsiConstant(new DsiConstant(null,"2014" ,"speedOfLightInVacuum", "Speed", "299792458.0", "\\metre\\second\\tothe{-1}", "2015-06-25T00:00:00Z" , "0.0", "normal"));
        speedOfLight2014.setMath(false);
        speedOfLight2014.setSIDefining(true);
        speedOfLight2014.setCOData(true);

        List <DsiIdentifier> dsiIdentifierList1 = new ArrayList<>();
        DsiIdentifier dsi11 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/speedOfLightInVacuum2014");
        DsiIdentifier dsi21 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/speedOfLightInVacuum");
        DsiIdentifier dsi31 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?c|search_for=speed+of+light");
        dsiIdentifierList1.add(dsi11);
        dsiIdentifierList1.add(dsi21);
        dsiIdentifierList1.add(dsi31);
        dsiIdentifierRepository.save(dsi11);
        dsiIdentifierRepository.save(dsi21);
        dsiIdentifierRepository.save(dsi31);
        speedOfLight2014.setIdentifier(dsiIdentifierList1);
        scientificConstantRepository.save(speedOfLight2014);

        /********************************************************************************/
        /*                          hyperfineTransitionFrequencyOfCs133 2018                                    */
        /********************************************************************************/
        ScientificConstant hyperfineTransitionFrequency18 = new ScientificConstant();
        hyperfineTransitionFrequency18.setName("hyperfineTransitionFrequencyOfCs133");
        hyperfineTransitionFrequency18.setYear("2018");
        hyperfineTransitionFrequency18.setDsiApproved(true);
        hyperfineTransitionFrequency18.setDsiConstant(new DsiConstant(null,"2018" ,"hyperfineTransitionFrequencyOfCs133", "Frequency", "9192631770.0", "\\hertz", "2019-05-20T00:00:00Z" , "0.0", "normal"));
        hyperfineTransitionFrequency18.setMath(false);
        hyperfineTransitionFrequency18.setSIDefining(true);
        hyperfineTransitionFrequency18.setCOData(true);

        List <DsiIdentifier> dsiIdentifierListHyperfine18 = new ArrayList<>();
        DsiIdentifier dsiHyperfine18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/hyperfineTransitionFrequencyOfCs1332018");
        DsiIdentifier dsiHyperfine28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/hyperfineTransitionFrequencyOfCs133");
        DsiIdentifier dsiHyperfine38 = new DsiIdentifier(null,"BIPM","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/caesium_transition_frequency");
        DsiIdentifier dsiHyperfine48 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?nucs|search_for=hyperfine");
        dsiIdentifierListHyperfine18.add(dsiHyperfine18);
        dsiIdentifierListHyperfine18.add(dsiHyperfine28);
        dsiIdentifierListHyperfine18.add(dsiHyperfine38);
        dsiIdentifierListHyperfine18.add(dsiHyperfine48);
        dsiIdentifierRepository.save(dsiHyperfine18);
        dsiIdentifierRepository.save(dsiHyperfine28);
        dsiIdentifierRepository.save(dsiHyperfine38);
        dsiIdentifierRepository.save(dsiHyperfine48);
        hyperfineTransitionFrequency18.setIdentifier(dsiIdentifierListHyperfine18);
        scientificConstantRepository.save(hyperfineTransitionFrequency18);


        /********************************************************************************/
        /*                          hyperfineTransitionFrequencyOfCs133 2006            */
        /********************************************************************************/
        ScientificConstant hyperfineTransitionFrequency06 = new ScientificConstant();
        hyperfineTransitionFrequency06.setName("hyperfineTransitionFrequencyOfCs133");
        hyperfineTransitionFrequency06.setYear("2006");
        hyperfineTransitionFrequency06.setDsiApproved(true);
        hyperfineTransitionFrequency06.setDsiConstant(new DsiConstant(null,"2006" ,"hyperfineTransitionFrequencyOfCs133", "Frequency", "9192631770.0", "\\hertz", "2006-03-01T00:00:00Z" , "0.0", "normal"));
        hyperfineTransitionFrequency06.setMath(false);
        hyperfineTransitionFrequency06.setSIDefining(true);
        hyperfineTransitionFrequency06.setCOData(false);

        List <DsiIdentifier> dsiIdentifierListHyperfine06 = new ArrayList<>();
        DsiIdentifier dsiHyperfine16 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/hyperfineTransitionFrequencyOfCs1332006");
        DsiIdentifier dsiHyperfine26 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/hyperfineTransitionFrequencyOfCs133");
        dsiIdentifierListHyperfine06.add(dsiHyperfine16);
        dsiIdentifierListHyperfine06.add(dsiHyperfine26);
        dsiIdentifierRepository.save(dsiHyperfine16);
        dsiIdentifierRepository.save(dsiHyperfine26);
        hyperfineTransitionFrequency06.setIdentifier(dsiIdentifierListHyperfine06);
        scientificConstantRepository.save(hyperfineTransitionFrequency06);

        /********************************************************************************/
        /*                        elementaryCharge2018                                  */
        /********************************************************************************/
        ScientificConstant elementaryCharge2018 = new ScientificConstant();
        elementaryCharge2018.setName("elementaryCharge");
        elementaryCharge2018.setYear("2018");
        elementaryCharge2018.setDsiApproved(true);
        elementaryCharge2018.setDsiConstant(new DsiConstant(null,"2018" ,"elementaryCharge", "ElectricCharge","1.602176634E-19", "\\coulomb", "2019-05-20T00:00:00Z" , "0.0", "normal"));
        elementaryCharge2018.setMath(false);
        elementaryCharge2018.setSIDefining(true);
        elementaryCharge2018.setCOData(true);

        List <DsiIdentifier> dsiIdElmentaryCharge18 = new ArrayList<>();
        DsiIdentifier dsiElementaryCharge18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/elementaryCharge2018");
        DsiIdentifier dsiElementaryCharge28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/elementaryCharge");
        DsiIdentifier dsiElementaryCharge38 = new DsiIdentifier(null,"BIPM","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/elementary_charge");
        DsiIdentifier dsiElementaryCharge48 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?e|search_for=elementary+charge");
        dsiIdElmentaryCharge18.add(dsiElementaryCharge18);
        dsiIdElmentaryCharge18.add(dsiElementaryCharge28);
        dsiIdElmentaryCharge18.add(dsiElementaryCharge38);
        dsiIdElmentaryCharge18.add(dsiElementaryCharge48);
        dsiIdentifierRepository.save(dsiElementaryCharge18);
        dsiIdentifierRepository.save(dsiElementaryCharge28);
        dsiIdentifierRepository.save(dsiElementaryCharge38);
        dsiIdentifierRepository.save(dsiElementaryCharge48);
        elementaryCharge2018.setIdentifier(dsiIdElmentaryCharge18);
        scientificConstantRepository.save(elementaryCharge2018);


        /********************************************************************************/
        /*                        elementaryCharge2014                                  */
        /********************************************************************************/
        ScientificConstant elementaryCharge2014 = new ScientificConstant();
        elementaryCharge2014.setName("elementaryCharge");
        elementaryCharge2014.setYear("2014");
        elementaryCharge2014.setDsiApproved(true);
        elementaryCharge2014.setDsiConstant(new DsiConstant(null,"2014" ,"elementaryCharge", "ElectricCharge","1.6021766208E-19", "\\coulomb", "2014-05-20T00:00:00Z" , "0.0000000098e-19", "normal"));
        elementaryCharge2014.setMath(false);
        elementaryCharge2014.setSIDefining(false);
        elementaryCharge2014.setCOData(true);

        List <DsiIdentifier> dsiIdElmentaryCharge14 = new ArrayList<>();
        DsiIdentifier dsiElementaryCharge14 = new DsiIdentifier(null,"DSI","https://ptb.de/si/d-constant/elementaryCharge2014");
        DsiIdentifier dsiElementaryCharge24 = new DsiIdentifier(null,"DSI","https://ptb.de/si/d-constant/elementaryCharge");
        DsiIdentifier dsiElementaryCharge34 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cuu/pdf/all_2014.pdf");

        dsiIdElmentaryCharge14.add(dsiElementaryCharge14);
        dsiIdElmentaryCharge14.add(dsiElementaryCharge24);
        dsiIdElmentaryCharge14.add(dsiElementaryCharge34);
        dsiIdentifierRepository.save(dsiElementaryCharge14);
        dsiIdentifierRepository.save(dsiElementaryCharge24);
        dsiIdentifierRepository.save(dsiElementaryCharge34);
        elementaryCharge2014.setIdentifier(dsiIdElmentaryCharge14);
        scientificConstantRepository.save(elementaryCharge2014);

        /********************************************************************************/
        /*                        boltzmannConstant 2018                               */
        /********************************************************************************/
        ScientificConstant boltzmannConstant18 = new ScientificConstant();
        boltzmannConstant18.setName("boltzmannConstant");
        boltzmannConstant18.setYear("2018");
        boltzmannConstant18.setDsiApproved(true);
        boltzmannConstant18.setDsiConstant(new DsiConstant(null,"2018" ,"boltzmannConstant", "HeatCapacity", "1.380649E-23", "\\joule\\kelvin\\tothe{-1}", "2019-05-20T00:00:00Z" , "0.0", "normal"));
        boltzmannConstant18.setMath(false);
        boltzmannConstant18.setSIDefining(true);
        boltzmannConstant18.setCOData(true);

        List <DsiIdentifier> dsiIdBoltzList18 = new ArrayList<>();
        DsiIdentifier dsiBoltz18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/boltzmannConstant2018");
        DsiIdentifier dsiBoltz28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/boltzmannConstant");
        DsiIdentifier dsiBoltz38 = new DsiIdentifier(null,"BIPM","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/boltzmann_constant");
        DsiIdentifier dsiBoltz48 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?k|search_for=boltzmann");
        dsiIdBoltzList18.add(dsiBoltz18);
        dsiIdBoltzList18.add(dsiBoltz28);
        dsiIdBoltzList18.add(dsiBoltz38);
        dsiIdBoltzList18.add(dsiBoltz48);
        dsiIdentifierRepository.save(dsiBoltz18);
        dsiIdentifierRepository.save(dsiBoltz28);
        dsiIdentifierRepository.save(dsiBoltz38);
        dsiIdentifierRepository.save(dsiBoltz48);
        boltzmannConstant18.setIdentifier(dsiIdBoltzList18);
        scientificConstantRepository.save(boltzmannConstant18);


        /********************************************************************************/
        /*                        boltzmannConstant 2014                                */
        /********************************************************************************/
        ScientificConstant boltzmannConstant14 = new ScientificConstant();
        boltzmannConstant14.setName("boltzmannConstant");
        boltzmannConstant14.setYear("2014");
        boltzmannConstant14.setDsiApproved(true);
        boltzmannConstant14.setDsiConstant(new DsiConstant(null,"2014" ,"boltzmannConstant", "HeatCapacity", "1.38064852E-23", "\\joule\\kelvin\\tothe{-1}", "2015-05-20T00:00:00Z" , "7.9E-30", "normal"));
        boltzmannConstant14.setMath(false);
        boltzmannConstant14.setSIDefining(false);
        boltzmannConstant14.setCOData(true);

        List <DsiIdentifier> dsiIdBoltzList14 = new ArrayList<>();
        DsiIdentifier dsiBoltz14 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/boltzmannConstant2014");
        DsiIdentifier dsiBoltz24 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/boltzmannConstant");
        DsiIdentifier dsiBoltz34 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cuu/pdf/all_2014.pdf");
        dsiIdBoltzList14.add(dsiBoltz14);
        dsiIdBoltzList14.add(dsiBoltz24);
        dsiIdBoltzList14.add(dsiBoltz34);
        dsiIdentifierRepository.save(dsiBoltz14);
        dsiIdentifierRepository.save(dsiBoltz24);
        dsiIdentifierRepository.save(dsiBoltz34);
        boltzmannConstant14.setIdentifier(dsiIdBoltzList14);
        scientificConstantRepository.save(boltzmannConstant14);

        /********************************************************************************/
        /*                        avogadroConstant 2018                                */
        /********************************************************************************/
        ScientificConstant avogadroConstant18 = new ScientificConstant();
        avogadroConstant18.setName("avogadroConstant");
        avogadroConstant18.setYear("2018");
        avogadroConstant18.setDsiApproved(true);
        avogadroConstant18.setDsiConstant(new DsiConstant(null,"2018" ,"avogadroConstant", "InverseAmountOfSubstance", "6.02214076E23", "\\mole\\tothe{-1}", "2019-05-20T00:00:00Z" , "0.0", "normal"));
        avogadroConstant18.setMath(false);
        avogadroConstant18.setSIDefining(true);
        avogadroConstant18.setCOData(true);
        List <DsiIdentifier> dsiIdAvogadoList18 = new ArrayList<>();
        DsiIdentifier dsiAvogado18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/avogadroConstant2018");
        DsiIdentifier dsiAvogado28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/avogadroConstant");
        DsiIdentifier dsiAvogado38 = new DsiIdentifier(null,"BIPM","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/avogadro_constant");
        DsiIdentifier dsiAvogado48 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?na|search_for=avogadro");
        dsiIdAvogadoList18.add(dsiAvogado18);
        dsiIdAvogadoList18.add(dsiAvogado28);
        dsiIdAvogadoList18.add(dsiAvogado38);
        dsiIdAvogadoList18.add(dsiAvogado48);
        dsiIdentifierRepository.save(dsiAvogado18);
        dsiIdentifierRepository.save(dsiAvogado28);
        dsiIdentifierRepository.save(dsiAvogado38);
        dsiIdentifierRepository.save(dsiAvogado48);
        avogadroConstant18.setIdentifier(dsiIdAvogadoList18);
        scientificConstantRepository.save(avogadroConstant18);


        /********************************************************************************/
        /*                        avogadroConstant 2014                                */
        /********************************************************************************/
        ScientificConstant avogadroConstant14 = new ScientificConstant();
        avogadroConstant14.setName("avogadroConstant");
        avogadroConstant14.setYear("2014");
        avogadroConstant14.setDsiApproved(true);
        avogadroConstant14.setDsiConstant(new DsiConstant(null,"2014" ,"avogadroConstant", "InverseAmountOfSubstance", "6.022140857E23", "\\mole\\tothe{-1}", "2015-06-25T00:00:00Z" , "0.000000074E23", "normal"));
        avogadroConstant14.setMath(false);
        avogadroConstant14.setSIDefining(false);
        avogadroConstant14.setCOData(true);
        List <DsiIdentifier> dsiIdAvogadoList14 = new ArrayList<>();
        DsiIdentifier dsiAvogado14 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/avogadroConstant2014");
        DsiIdentifier dsiAvogado24 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/avogadroConstant");
        DsiIdentifier dsiAvogado34 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cuu/pdf/all_2014.pdf");
        dsiIdAvogadoList14.add(dsiAvogado14);
        dsiIdAvogadoList14.add(dsiAvogado24);
        dsiIdAvogadoList14.add(dsiAvogado34);
        dsiIdentifierRepository.save(dsiAvogado14);
        dsiIdentifierRepository.save(dsiAvogado24);
        dsiIdentifierRepository.save(dsiAvogado34);
        avogadroConstant14.setIdentifier(dsiIdAvogadoList14);
        scientificConstantRepository.save(avogadroConstant14);



        /********************************************************************************/
        /*                        luminousEfficacy 2018                                  */
        /********************************************************************************/
        ScientificConstant luminousEfficacy2018 = new ScientificConstant();
        luminousEfficacy2018.setName("luminousEfficacy");
        luminousEfficacy2018.setYear("2018");
        luminousEfficacy2018.setDsiApproved(true);
        luminousEfficacy2018.setDsiConstant(new DsiConstant(null,"2018" ,"luminousEfficacy", "LuminousFluxPerPower (non QUDT)", "683.0", "\\lumen\\watt\\tothe{-1}", "2019-05-20T00:00:00Z" , "0.0", "normal"));
        luminousEfficacy2018.setMath(false);
        luminousEfficacy2018.setSIDefining(true);
        luminousEfficacy2018.setCOData(true);

        List <DsiIdentifier> dsiIdLuminousEfficacy18 = new ArrayList<>();
        DsiIdentifier dsiLuminousEfficacy18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/luminousEfficacy2018");
        DsiIdentifier dsiLuminousEfficacy28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/luminousEfficacy");
        DsiIdentifier dsiLuminousEfficacy38 = new DsiIdentifier(null,"BIPM","https://siunits.stuchalk.domains.unf.edu/si/definingconstant/luminous_efficacy");
        DsiIdentifier dsiLuminousEfficacy48 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?kcd|search_for=luminous");
        dsiIdLuminousEfficacy18.add(dsiLuminousEfficacy18);
        dsiIdLuminousEfficacy18.add(dsiLuminousEfficacy28);
        dsiIdLuminousEfficacy18.add(dsiLuminousEfficacy38);
        dsiIdLuminousEfficacy18.add(dsiLuminousEfficacy48);
        dsiIdentifierRepository.save(dsiLuminousEfficacy18);
        dsiIdentifierRepository.save(dsiLuminousEfficacy28);
        dsiIdentifierRepository.save(dsiLuminousEfficacy38);
        dsiIdentifierRepository.save(dsiLuminousEfficacy48);
        luminousEfficacy2018.setIdentifier(dsiIdLuminousEfficacy18);
        scientificConstantRepository.save(luminousEfficacy2018);

        /********************************************************************************/
        /*                         protonElectronMassRatio 2018                               */
        /********************************************************************************/
        ScientificConstant protonElectron18 = new ScientificConstant();
        protonElectron18.setName("protonElectronMassRatio");
        protonElectron18.setYear("2018");
        protonElectron18.setDsiApproved(true);
        protonElectron18.setDsiConstant(new DsiConstant(null,"2018" ,"protonElectronMassRatio", "proton-electron mass ratio", "1836.15267343", "\\kilogram\\kilogram\\tothe{-1}", "2019-05-20T00:00:00Z" , "0.00000011", "normal"));
        protonElectron18.setMath(false);
        protonElectron18.setSIDefining(false);
        protonElectron18.setCOData(true);
        List <DsiIdentifier> dsiIdprotonElectronList18 = new ArrayList<>();
        DsiIdentifier dsiprotonElectron18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/protonElectronMassRatio2018");
        DsiIdentifier dsiprotonElectron28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/protonElectronMassRatio");
        DsiIdentifier dsiprotonElectron38 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cgi-bin/cuu/Value?mpsme|search_for=proton+electron+mass+ratio");
        dsiIdprotonElectronList18.add(dsiprotonElectron18);
        dsiIdprotonElectronList18.add(dsiprotonElectron28);
        dsiIdprotonElectronList18.add(dsiprotonElectron38);
        dsiIdentifierRepository.save(dsiprotonElectron18);
        dsiIdentifierRepository.save(dsiprotonElectron28);
        dsiIdentifierRepository.save(dsiprotonElectron38);
        protonElectron18.setIdentifier(dsiIdprotonElectronList18);
        scientificConstantRepository.save(protonElectron18);

        /********************************************************************************/
        /*                         protonElectronMassRatio 2014                                */
        /********************************************************************************/
        ScientificConstant protonElectron14 = new ScientificConstant();
        protonElectron14.setName("protonElectronMassRatio");
        protonElectron14.setYear("2014");
        protonElectron14.setDsiApproved(true);
        protonElectron14.setDsiConstant(new DsiConstant(null,"2014" ,"protonElectronMassRatio" +
                "", "proton-electron mass ratio", "1836.15267389", "\\kilogram\\kilogram\\tothe{-1}", "2015-06-25T00:00:00Z" , "0.00000017", "normal"));
        protonElectron14.setMath(false);
        protonElectron14.setSIDefining(false);
        protonElectron14.setCOData(true);
        List <DsiIdentifier> dsiIdprotonElectronList14 = new ArrayList<>();
        DsiIdentifier dsiprotonElectron14 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/protonElectronMassRatio2014");
        DsiIdentifier dsiprotonElectron24 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/protonElectronMassRatio");
        DsiIdentifier dsiprotonElectron34 = new DsiIdentifier(null,"CODATA","https://pml.nist.gov/cuu/pdf/all_2014.pdf");
        dsiIdprotonElectronList14.add(dsiprotonElectron14);
        dsiIdprotonElectronList14.add(dsiprotonElectron24);
        dsiIdprotonElectronList14.add(dsiprotonElectron34);
        dsiIdentifierRepository.save(dsiprotonElectron14);
        dsiIdentifierRepository.save(dsiprotonElectron24);
        dsiIdentifierRepository.save(dsiprotonElectron34);
        protonElectron14.setIdentifier(dsiIdprotonElectronList14);
        scientificConstantRepository.save(protonElectron14);


        /********************************************************************************/
        /*                        piDigits8                                             */
        /********************************************************************************/
        ScientificConstant pi2023 = new ScientificConstant();
        pi2023.setName("pi");
        pi2023.setYear("Digits8");
        pi2023.setDsiApproved(true);
        pi2023.setDsiConstant(new DsiConstant(null,"Digits8" ,"pi", "DimensionlessRatio", "3.14159265", "\\metre\\metre\\tothe{-1}", "2023-06-12T00:00:00Z" , "2.9E-9", "rectangular"));
        pi2023.setMath(true);
        pi2023.setSIDefining(false);
        pi2023.setCOData(false);

        List <DsiIdentifier> dsiIdPiList14 = new ArrayList<>();
        DsiIdentifier dsiIdPi14 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/piDigits8");
        DsiIdentifier dsiIdPi24 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/pi");
        dsiIdPiList14.add(dsiIdPi14);
        dsiIdPiList14.add(dsiIdPi24);
        dsiIdentifierRepository.save(dsiIdPi14);
        dsiIdentifierRepository.save(dsiIdPi24);
        pi2023.setIdentifier(dsiIdPiList14);
        scientificConstantRepository.save(pi2023);

        /********************************************************************************/
        /*                        piDigits16                                              */
        /********************************************************************************/
        ScientificConstant piDigits16 = new ScientificConstant();
        piDigits16.setName("pi");
        piDigits16.setYear("Digits16");
        piDigits16.setDsiApproved(true);
        piDigits16.setDsiConstant(new DsiConstant(null,"Digits16" ,"pi", "DimensionlessRatio", "3.141592653589793", "\\metre\\metre\\tothe{-1}", "2023-06-12T00:00:00Z" , "2.9E-17", "rectangular"));
        piDigits16.setMath(true);
        piDigits16.setSIDefining(false);
        piDigits16.setCOData(false);

        List <DsiIdentifier> dsiIdPiDigits16 = new ArrayList<>();
        DsiIdentifier dsiDigits16 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/piDigits16");
        DsiIdentifier dsiDigits26 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/pi");
        dsiIdPiDigits16.add(dsiDigits16);
        dsiIdPiDigits16.add(dsiDigits26);
        dsiIdentifierRepository.save(dsiDigits16);
        dsiIdentifierRepository.save(dsiDigits26);
        piDigits16.setIdentifier(dsiIdPiDigits16);
        scientificConstantRepository.save(piDigits16);

        /********************************************************************************/
        /*                        piDigits32                                            */
        /********************************************************************************/
        ScientificConstant piDigits32 = new ScientificConstant();
        piDigits32.setName("pi");
        piDigits32.setYear("Digits32");
        piDigits32.setDsiApproved(true);
        piDigits32.setDsiConstant(new DsiConstant(null,"Digits32" ,"pi", "DimensionlessRatio", "3.14159265358979323846264338327950", "\\metre\\metre\\tothe{-1}", "2023-06-12T00:00:00Z" , "2.9E-33", "rectangular"));
        piDigits32.setMath(true);
        piDigits32.setSIDefining(false);
        piDigits32.setCOData(false);

        List <DsiIdentifier> dsiIdPiDigits32 = new ArrayList<>();
        DsiIdentifier dsiDigits32 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/piDigits32");
        DsiIdentifier dsiDigits12 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/pi");
        dsiIdPiDigits32.add(dsiDigits32);
        dsiIdPiDigits32.add(dsiDigits12);
        dsiIdentifierRepository.save(dsiDigits32);
        dsiIdentifierRepository.save(dsiDigits12);
        piDigits32.setIdentifier(dsiIdPiDigits32);
        scientificConstantRepository.save(piDigits32);


        /********************************************************************************/
        /*                        eDigits8                                              */
        /********************************************************************************/
        ScientificConstant eDigits8 = new ScientificConstant();
        eDigits8.setName("e");
        eDigits8.setYear("Digits8");
        eDigits8.setDsiApproved(true);
        eDigits8.setDsiConstant(new DsiConstant(null,"Digits8" ,"e", "Dimensionless", "2.71828183", "\\one", "2023-06-12T00:00:00Z" , "2.9E-9", "rectangular"));
        eDigits8.setMath(true);
        eDigits8.setSIDefining(false);
        eDigits8.setCOData(false);

        List <DsiIdentifier> dsiIdEDigits8 = new ArrayList<>();
        DsiIdentifier dsiEDigits18 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/eDigits8");
        DsiIdentifier dsiEDigits28 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/e");
        dsiIdEDigits8.add(dsiEDigits18);
        dsiIdEDigits8.add(dsiEDigits28);
        dsiIdentifierRepository.save(dsiEDigits18);
        dsiIdentifierRepository.save(dsiEDigits28);
        eDigits8.setIdentifier(dsiIdEDigits8);
        scientificConstantRepository.save(eDigits8);

        /********************************************************************************/
        /*                        eDigits16                                            */
        /********************************************************************************/
        ScientificConstant eDigits16 = new ScientificConstant();
        eDigits16.setName("e");
        eDigits16.setYear("Digits16");
        eDigits16.setDsiApproved(true);
        eDigits16.setDsiConstant(new DsiConstant(null,"Digits16" ,"e", "Dimensionless", "2.7182818284590452", "\\one", "2023-06-12T00:00:00Z" , "2.9E-17", "rectangular"));
        eDigits16.setMath(true);
        eDigits16.setSIDefining(false);
        eDigits16.setCOData(false);

        List <DsiIdentifier> dsiIdEDigits16 = new ArrayList<>();
        DsiIdentifier dsiEDigits16 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/eDigits16");
        DsiIdentifier dsiEDigits26 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/e");
        dsiIdEDigits16.add(dsiEDigits16);
        dsiIdEDigits16.add(dsiEDigits26);
        dsiIdentifierRepository.save(dsiEDigits16);
        dsiIdentifierRepository.save(dsiEDigits26);
        eDigits16.setIdentifier(dsiIdEDigits16);
        scientificConstantRepository.save(eDigits16);


        /********************************************************************************/
        /*                        eDigits32                                             */
        /********************************************************************************/
        ScientificConstant eDigits32 = new ScientificConstant();
        eDigits32.setName("e");
        eDigits32.setYear("Digits32");
        eDigits32.setDsiApproved(true);
        eDigits32.setDsiConstant(new DsiConstant(null,"Digits32" ,"e", "Dimensionless", "2.71828182845904523536028747135266", "\\one", "2023-06-12T00:00:00Z" , "2.9E-33", "rectangular"));
        eDigits32.setMath(true);
        eDigits32.setSIDefining(false);
        eDigits32.setCOData(false);

        List <DsiIdentifier> dsiIdEDigits32 = new ArrayList<>();
        DsiIdentifier dsiEDigits32 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/eDigits32");
        DsiIdentifier dsiEDigits12 = new DsiIdentifier(null,"DSI","https://d-si.ptb.de/api/d-constant/e");
        dsiIdEDigits32.add(dsiEDigits32);
        dsiIdEDigits32.add(dsiEDigits12);
        dsiIdentifierRepository.save(dsiEDigits32);
        dsiIdentifierRepository.save(dsiEDigits12);
        eDigits32.setIdentifier(dsiIdEDigits32);
        scientificConstantRepository.save(eDigits32);

    }

}

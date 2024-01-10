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
 * along with this XSD. If not, see http://www.gnu.org/licenses.
 * CONTACT: info@ptb.de
 * DEVELOPMENT: https://d-si.ptb.de
 * AUTHORS: Wafa El Jaoua, Tobias Hoffmann, Clifford Brown, Daniel Hutzschenreuter
 * LAST MODIFIED: 17.12.23, 00:25
 */

package de.ptb.codataapi.repository;


import de.ptb.codataapi.model.DsiIdentifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class DsiIdentifierRepositoryTest {

    @Autowired
    private DsiIdentifierRepository dsiIdentifierRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void should_find_no_dsiIdentifier_if_dsiIdentifiers_is_empty() {
        Iterable identifiers = dsiIdentifierRepository.findAll();
        assertThat(identifiers).isEmpty();

    }
    @Test
    public void should_store_a_dsiIdentifier() {
        DsiIdentifier dsi01 = new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/planckConstant2016");
        assertThat(dsi01).hasFieldOrPropertyWithValue("publisher", "DSI");
        assertThat(dsi01).hasFieldOrPropertyWithValue("identifier", "https://ptb.de/si/d-constant/planckConstant2016");

    }
    @Test
    public void should_find_all_dsiIdentifiers() {
        DsiIdentifier dsi01 = new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/planckConstant2016");
        DsiIdentifier dsi02 = new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/codata/planckConstant");
        DsiIdentifier dsi03 = new DsiIdentifier(null, "BIPM", "https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        DsiIdentifier dsi04 = new DsiIdentifier(null, "CODATA", "https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        entityManager.persist(dsi01);
        entityManager.persist(dsi02);
        entityManager.persist(dsi03);
        entityManager.persist(dsi04);
        Iterable savedDsiIdentifierList = dsiIdentifierRepository.findAll();
        assertThat(savedDsiIdentifierList).hasSize(4).contains(dsi01,dsi02,dsi03,dsi04);

    }
}
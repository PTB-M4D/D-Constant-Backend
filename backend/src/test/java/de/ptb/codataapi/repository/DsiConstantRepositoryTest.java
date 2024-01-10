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
 * LAST MODIFIED: 19.12.23, 16:36
 */

package de.ptb.codataapi.repository;

import de.ptb.codataapi.model.DsiConstant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DsiConstantRepositoryTest {

    @Autowired
    private DsiConstantRepository dsiConstantRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    public void should_find_no_dsiConstant_if_dsiConstants_is_empty() {
        DsiConstant constant = new DsiConstant(null,
                "2016",
                "planckConstant",
                "Action",
                "6.62607015E-34",
                "\\joule\\hertz\\tothe{-1}",
                "2018-05-20T00:00:00Z",
                "0.0",
                "normal");
        entityManager.persist(constant);
        assertThat(constant).isNotNull();
        assertThat(constant).hasFieldOrPropertyWithValue("year", "2016");

    }

    @Test
    public void should_store_a_constant() {
        DsiConstant constant2 = entityManager.persist(new DsiConstant(null, "2017", "planckConstant1", "Action1", "6.62607015E-34", "\\joule\\hertz\\tothe{-1}", "2018-05-20T00:00:00Z", "0.0", "normal"));
        Iterable constant3 = dsiConstantRepository.findAll();
        assertThat(constant3).isNotNull();
        assertThat(constant2).isNotNull();

    }
}
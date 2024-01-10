

package de.ptb.codataapi.repository;


import de.ptb.codataapi.model.DsiConstant;
import de.ptb.codataapi.model.DsiIdentifier;
import de.ptb.codataapi.model.ScientificConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
public class ScientificConstantRepositoryTest {
    @Autowired
    private ScientificConstantRepository repository;
    @Autowired
    private DsiIdentifierRepository dsiIdentifierRepository;
    @Autowired
    private TestEntityManager entityManager;



    @Test
    public void findScientificConstantByNameYearTest() {

        List<DsiIdentifier> dsiIdentifierList0 = new ArrayList<>();
        DsiIdentifier dsi01 = new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/planckConstant2016");
        DsiIdentifier dsi02 = new DsiIdentifier(null, "DSI", "https://ptb.de/si/d-constant/codata/planckConstant");
        DsiIdentifier dsi03 = new DsiIdentifier(null, "BIPM", "https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        DsiIdentifier dsi04 = new DsiIdentifier(null, "CODATA", "https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant");
        dsiIdentifierList0.add(dsi01);
        dsiIdentifierList0.add(dsi02);
        dsiIdentifierList0.add(dsi03);
        dsiIdentifierList0.add(dsi04);
        dsiIdentifierRepository.save(dsi01);
        dsiIdentifierRepository.save(dsi02);
        dsiIdentifierRepository.save(dsi03);
        dsiIdentifierRepository.save(dsi04);
        List<DsiIdentifier> savedDsiIdentifierList = dsiIdentifierRepository.findAll();

        DsiConstant constant = new DsiConstant(null,
                "2016",
                "planckConstant",
                "Action",
                "6.62607015E-34",
                "\\joule\\hertz\\tothe{-1}",
                "2018-05-20T00:00:00Z",
                "0.0",
                "normal");

        ScientificConstant planckConstant = new ScientificConstant(null,
                "planckConstant",
                "2016",
                "planckConstant2016",
                savedDsiIdentifierList,
                true,
                constant,
                true,
                true,
                false);
        entityManager.persist(planckConstant);
        ScientificConstant expected = repository.findById(1L).get();
//        ScientificConstant expected= repository.save(planckConstant);
        String name= "planckConstant2016";
        Assertions.assertEquals(expected, planckConstant);
        assertThat(planckConstant).isNotNull();
        assertThat(planckConstant).hasFieldOrPropertyWithValue("year", "2016");
        assertThat(planckConstant).hasFieldOrPropertyWithValue("name", "planckConstant");
        assertThat(planckConstant).hasFieldOrPropertyWithValue("dsiApproved", true);
        Assertions.assertEquals(1, repository.findById(1L).stream().toList().size());
//        TO DO
//        Assertions.assertEquals(planckConstant, repository.findScientificConstantByNameYear(name));
        assertThat( planckConstant.getId()).isGreaterThan(0);
        Assertions.assertEquals(4, dsiIdentifierRepository.findAll().size());
    }
//    @Test
//    public void should_throw_invalidDataAccess_exception_if_constant_is_null() {
//        assertThrows(InvalidDataAccessResourceUsageException.class,()->repository.findById(1L).get());
//    }

}
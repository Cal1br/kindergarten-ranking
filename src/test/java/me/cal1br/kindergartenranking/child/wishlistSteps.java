package me.cal1br.kindergartenranking.child;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.child.repository.ChildRepository;
import me.cal1br.kindergartenranking.child.repository.ChildRepositoryImpl;
import me.cal1br.kindergartenranking.child.service.ChildService;
import me.cal1br.kindergartenranking.child.service.ChildServiceImpl;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;
import me.cal1br.kindergartenranking.kindergarten.repository.KindergartenRepository;
import me.cal1br.kindergartenranking.kindergarten.repository.KindergartenRepositoryImpl;
import me.cal1br.kindergartenranking.kindergarten.service.KindergartenService;
import me.cal1br.kindergartenranking.kindergarten.service.KindergartenServiceImpl;
import me.cal1br.kindergartenranking.parent.repository.ParentRepository;
import me.cal1br.kindergartenranking.parent.repository.ParentRepositoryImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class wishlistSteps {

    private final ChildModel child = new ChildModel();
    //Repositories
    private final KindergartenRepository kindergartenRepository = new KindergartenRepositoryImpl();
    private final ChildRepository childRepository = new ChildRepositoryImpl();
    private final ParentRepository parentRepository = new ParentRepositoryImpl();
    //Services
    private final KindergartenService kindergartenService = new KindergartenServiceImpl(parentRepository, childRepository, kindergartenRepository);
    private final ChildService childService = new ChildServiceImpl(childRepository);
    //private final ChildModel secondWishChild = new ChildModel();
    private Map<KindergartenModel, List<ChildModel>> rankedChildrenByKG = new HashMap<>();

    {
        final KindergartenModel kindergarten0 = new KindergartenModel();
        kindergarten0.setName("Zdravec");
        kindergarten0.setPlaces(5);
        final KindergartenModel kindergarten1 = new KindergartenModel();
        kindergarten1.setName("KinderSurprise");
        kindergarten1.setPlaces(5);
        kindergartenService.save(kindergarten0);
        kindergartenService.save(kindergarten1);

        child.setName("Artyom");
        child.setDateOfBirth(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")).minusYears(5));
        //secondWishChild.setName("Charlie");
    }

    @Before
    public void setUp() {
        child.setWishList(kindergartenService.findAll());
        childService.save(child);
    }

    @Given("^There is a child$")
    public void thereIsAChild() {
        assertFalse(childService.findAll().isEmpty());
    }

    @And("^There is a kindergarten$")
    public void thereIsAKindergarten() {
        assertFalse(kindergartenService.findAll().isEmpty());
    }

    @Given("^Child has no wishlist$")
    public void childHasNoWishlist() throws Throwable {
        child.setWishList(Collections.emptyList());
        childService.editById(child.getId(), child);
        assertTrue(childService.findById(child.getId()).getWishList().isEmpty());
    }

    @And("^First wish kindergarten has no spots$")
    public void firstWishKindergartenHasNoSpots() {
        final KindergartenModel kindergarten = child.getWishList().get(0);
        kindergarten.setPlaces(0);
        kindergartenService.editById(kindergarten.getId(), kindergarten);
    }

    @Given("^Child has wishlist$")
    public void childHasWishlist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertNotNull(child.getWishList());
        assertFalse(child.getWishList().isEmpty());
    }

    @When("^Ranking is processed$")
    public void rankingIsProcessed() throws Throwable {
        rankedChildrenByKG = kindergartenService.rankChildren(kindergartenService.findAll(), Collections.singletonList(child));
        assertNotNull(rankedChildrenByKG.keySet());
        assertNotNull(rankedChildrenByKG.values());
    }

    @Then("^Child is accepted into a kindergarten$")
    public void childIsAcceptedIntoAKindergarten() throws Throwable {
        assertTrue(rankedChildrenByKG.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .contains(child));
    }

    @Then("^Child isn't accepted anywhere$")
    public void childIsnTAcceptedAnywhere() throws Throwable {
        assertFalse(rankedChildrenByKG.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .contains(child));
    }

    @Given("^Kindergarten has no spots$")
    public void kindergartenHasNoSpots() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        kindergartenRepository.findAll().stream().forEach(kindergarten -> {
            kindergarten.setPlaces(0);
            kindergartenService.editById(kindergarten.getId(), kindergarten);
        });
    }

}

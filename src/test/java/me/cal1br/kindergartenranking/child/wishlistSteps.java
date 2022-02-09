package me.cal1br.kindergartenranking.child;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.child.repository.ChildRepository;
import me.cal1br.kindergartenranking.child.repository.ChildRepositoryImpl;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;
import me.cal1br.kindergartenranking.kindergarten.repository.KindergartenRepository;
import me.cal1br.kindergartenranking.kindergarten.repository.KindergartenRepositoryImpl;
import me.cal1br.kindergartenranking.kindergarten.service.KindergartenService;
import me.cal1br.kindergartenranking.kindergarten.service.KindergartenServiceImpl;
import me.cal1br.kindergartenranking.parent.repository.ParentRepository;
import me.cal1br.kindergartenranking.parent.repository.ParentRepositoryImpl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class wishlistSteps {

    private final ChildModel child = new ChildModel();
    private final List<KindergartenModel> wishList = new LinkedList<>();
    private KindergartenService kindergartenService;
    private Map<KindergartenModel, List<ChildModel>> rankedChildrenByKG;

    @Before
    public void setUp() {
        final KindergartenModel kindergarten0 = new KindergartenModel();
        kindergarten0.setName("Zdravec");
        kindergarten0.setPlaces(5);
        final KindergartenModel kindergarten1 = new KindergartenModel();
        kindergarten1.setName("KinderSurprise");
        kindergarten1.setPlaces(5);
        final KindergartenRepository kindergartenRepository = new KindergartenRepositoryImpl();
        kindergartenRepository.save(kindergarten0);
        kindergartenRepository.save(kindergarten1);
        wishList.addAll(kindergartenRepository.getAll());
        final ChildRepository childRepository = new ChildRepositoryImpl();
        kindergartenRepository.save(kindergarten0);
        kindergartenRepository.save(kindergarten1);
        final ParentRepository parentRepository = new ParentRepositoryImpl();
        kindergartenService = new KindergartenServiceImpl(parentRepository, childRepository, kindergartenRepository);
    }

    @Given("^Child has wishlist$")
    public void childHasWishlist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        child.setWishList(wishList);
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
}

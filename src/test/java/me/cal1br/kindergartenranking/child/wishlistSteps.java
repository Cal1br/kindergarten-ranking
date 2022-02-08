package me.cal1br.kindergartenranking.child;

import cucumber.api.PendingException;
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

public class wishlistSteps {

    private final ChildModel child = new ChildModel();
    private final List<KindergartenModel> wishList = new LinkedList<>();
    private KindergartenService kindergartenService;

    @Before
    public void setUp() {
        final KindergartenModel kindergarten0 = new KindergartenModel();
        kindergarten0.setName("Zdravec");
        kindergarten0.setPlaces(5);
        final KindergartenModel kindergarten1 = new KindergartenModel();
        kindergarten1.setName("KinderSurprise");
        kindergarten1.setPlaces(5);
        wishList.add(kindergarten0);
        wishList.add(kindergarten1);
        final KindergartenRepository kindergartenRepository = new KindergartenRepositoryImpl();
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
    }

    @When("^Ranking is processed$")
    public void rankingIsProcessed() throws Throwable {
        kindergartenService.rankChildren(kindergartenService.findAll(), Collections.singletonList(child));
        throw new PendingException();
    }

    @Then("^Child is accepted into a kindergarten$")
    public void childIsAcceptedIntoAKindergarten() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Child is accepted into second kindergarten$")
    public void childIsAcceptedIntoSecondKindergarten() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Child has no wishlist$")
    public void childHasNoWishlist() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Rankin is processed$")
    public void rankinIsProcessed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Child isn't accepted anywhere$")
    public void childIsnTAcceptedAnywhere() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Kindergarten has no spots$")
    public void kindergartenHasNoSpots() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

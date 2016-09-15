package com.encoway.ecasta_example.step;

import static org.junit.Assert.assertTrue;

import com.encoway.ecasta_example.pages.SearchPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Step for search.feature.
 */
public class SearchStep {

    @Given("the user has started the application")
    public void startApplication() {
        SearchPage articlePage = new SearchPage();
        articlePage.get();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void searchFor(String search) throws Throwable {
        SearchPage searchPage = getSearchPage();
        searchPage.submitSearch(search);
    }

    @Then("^a browser title should contains \"([^\"]*)\"$")
    public void a_browser_title_should_contains(String text) throws Throwable {
        SearchPage searchPage = getSearchPage();
        assertTrue(searchPage.getTitle().contains(text));
    }

    private SearchPage getSearchPage() {
        SearchPage searchPage = new SearchPage();
        searchPage.get();
        return searchPage;
    }

}

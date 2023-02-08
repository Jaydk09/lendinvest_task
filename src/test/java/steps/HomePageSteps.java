package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class HomePageSteps extends HomePage {

    protected Logger LOGGER;

    @Given("I am a non-registered customer")
    public void i_am_a_non_registered_customer() {
        LOGGER = Logger.getLogger("I am a non-registered customer");

    }
    @And("I navigate to www.ebay.co.uk")
    public void i_navigate_to_www_ebay_co_uk() {
        openHomePage();
        clickAcceptAllCookies();
        assertHomePageIsInitialised();
    }
    @When("I search for item - {}")
    public void i_enter_search_term_and_select_a_specific_category(String searchKeyword) {
        inputSearchTermInSearchField(searchKeyword);
        clickSearchBtn();
    }

    @Then("I get a list of matching results")
    public void i_get_a_list_of_matching_results() {
        assertResultsDisplayed();
    }

    @And("the results displayed show the item prices")
    public void theResultsDisplayedShowTheItemPrices() {
        assertPriceDisplayedInResultsCards();
    }

    @When("I sort the results by Lowest Price")
    public void iSortTheResultsByLowestPrice() {
        filterResultsByLowestPrice();
    }
}

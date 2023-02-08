package pages;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends TestBase {

    private final SelenideElement acceptAllCookiesBtn = $(By.id("gdpr-banner-accept"));
    private final SelenideElement searchBox = $(By.id("gh-ac"));
    private final SelenideElement searchBtn = $(By.id("gh-btn"));
    private final SelenideElement results = $(By.cssSelector("h1.srp-controls__count-heading"));
    private final SelenideElement searchKeywordInResults = $(By.xpath("//h1[@class=\"srp-controls__count-heading\"]/span[@class=\"BOLD\"][2]"));

//    private final SelenideElement resultCards = $("li.s-item.s-item__pl-on-bottom.s-item--watch-at-corner");

    private final List<SelenideElement> resultsCards = $$("li.s-item.s-item__pl-on-bottom.s-item--watch-at-corner");
    private final List<SelenideElement> itemPrices = $$("li.s-item.s-item__pl-on-bottom.s-item--watch-at-corner>div.s-item__wrapper.clearfix>div.s-item__info.clearfix>div.s-item__details.clearfix>div>span.s-item__price");
   private final SelenideElement resultsFilterDropDown = $("span#nid-yc2-1>button>span.btn__cell");
private final SelenideElement dropDownOptionLowestPrice = $(By.xpath("//span[@class=\"btn__cell\"]/span[text()=\"Lowest price + P&P\"]"));
    protected String searchKeyword = "";

    // opens url set under base url in TestBase.java
    protected void openHomePage() {
        open("/");
    }
protected void filterResultsByLowestPrice(){
        resultsFilterDropDown.shouldBe(visible).click();
        dropDownOptionLowestPrice.shouldBe(visible).click();
}
    protected void assertPriceDisplayedInResultsCards() {

        for (SelenideElement itemPrice : itemPrices) {
            Assert.assertTrue(itemPrice.innerText().contains("£"));
        }
    }


    protected void assertHomePageTitle() {
        Allure.addAttachment("Home Page Title", Objects.requireNonNull(title()));
        Assert.assertEquals("Electronics, Cars, Fashion, Collectibles & More | eBay", title());
    }

    protected void assertHomePageIsInitialised() {
        assertHomePageTitle();
    }

    protected void clickAcceptAllCookies() {
        if (acceptAllCookiesBtn.isDisplayed()) {
            acceptAllCookiesBtn.click();
        }
    }

    protected void inputSearchTermInSearchField(String searchKeyword) {
        this.searchKeyword = searchKeyword;
        searchBox.shouldBe(enabled).setValue(this.searchKeyword);
    }

    protected void clickSearchBtn() {
        searchBtn.shouldBe(enabled).click();
    }

    protected void inputKeywordSelectCategoryClickSearchBtn(String searchKeyword, String categoryName) {
        inputSearchTermInSearchField(searchKeyword);
        clickSearchBtn();
    }

    protected String getResults() {
        return results.getText();
    }

    protected void assertResultsDisplayed() {
        System.out.println("Results -> " + getResults());
        Allure.addAttachment("Results", getResults());

//        softAssertions.assertThat(results.isDisplayed()).isTrue();
    }

    protected void assertSearchKeywordMatchesResults() {
        System.out.println("Search Keyword -> " + searchKeywordInResults.getText());
        Allure.addAttachment("Search Keyword", searchKeywordInResults.getText());
//        softAssertions.assertThat(searchKeywordInResults.getText()).isEqualToIgnoringCase(searchKeyword);
    }

//    protected void assertAllTests(){
//        softAssertions.assertAll();
//    }
}

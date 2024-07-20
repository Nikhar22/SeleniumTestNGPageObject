package tests;

import utils.Author;
import constants.Filters;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EbayTest extends TestBase {



    @Test(enabled = true,
            description = "Access product via category after applying multiple filters")
    @Author(name="Nikhar Trivedi")
    public void accessProductByCategoryAndFilterTest(){
        basePage.getHomePage().clickOnHeader();
        basePage.getHomePage().moveToAccessoriesNCLick();
        basePage.getPhoneAccePage().waitForCellPhoneAccessoriesPageToBeDisplayed();
        basePage.getPhoneAccePage().moveToAllFiltersAndClick();
        basePage.getPhoneAccePage().moveToFilterAndSelectSingleCategory(Filters.Condition);
        Reporter.log("Applied Condition filter", true);
        basePage.getPhoneAccePage().moveToFilterAndSelectSingleCategory(Filters.Price);
        Reporter.log("Applied Price filter", true);
        basePage.getPhoneAccePage().moveToFilterAndSelectSingleCategory(Filters.Location);
        Reporter.log("Applied Location filter", true);

        Assert.assertTrue(basePage.getPhoneAccePage().assertAppliedFilterValues(Filters.Condition.getFilterValue()), "Condition Filter is not applied");
        Assert.assertTrue(basePage.getPhoneAccePage().assertAppliedFilterValues(Filters.Price.getFilterValue()), "Max Price Filter is not applied");
        Assert.assertTrue(basePage.getPhoneAccePage().assertAppliedFilterValues(Filters.Location.getFilterValue()), "Max Price Filter is not applied");
        Reporter.log("Condition, Location and Price Filter Got Selected", true);
        basePage.getPhoneAccePage().clickOnApplyFilter();
        basePage.getPhoneAccePage().assertAppliedFilterCountPage(3);
        basePage.getPhoneAccePage().tapOnFiltersAppliedBtn();
        basePage.getPhoneAccePage().assertSelectedFiltersAndValuesAppliedDisplaying(Filters.Price);
        basePage.getPhoneAccePage().assertSelectedFiltersAndValuesAppliedDisplaying(Filters.Location);
        basePage.getPhoneAccePage().assertSelectedFiltersAndValuesAppliedDisplaying(Filters.Condition);
        Reporter.log("Condition, Location and Price Filters Got applied successfully and validated", true);
        }


    @Test(enabled = true,
            description = "Access a product via search")
    @Author(name="Nikhar Trivedi")
    public void accessProductBySearchTest(){
        String productName = "mobile";
        String productCategory =  "Computers/Tablets & Networking";
        basePage.getHomePage().inputSearchProductName(productName);
        basePage.getHomePage().selectCategory(productCategory);
        basePage.getHomePage().clickOnSearchButton();
        Reporter.log("Searched for "+productName+ " and clicked on Search button", true);
        Assert.assertEquals(basePage.getSearchPage().searchResultHeadingProductName(), productName, "Searched Product name not present in header" +basePage.getSearchPage().searchResultHeadingProductName());
        Assert.assertTrue(basePage.getSearchPage().getFirstSearchResultProductName().contains(productName), "1st Search result doesn't contain product name "+basePage.getSearchPage().getFirstSearchResultProductName());
        Reporter.log("First search result displaying product successfully", true);

    }


}

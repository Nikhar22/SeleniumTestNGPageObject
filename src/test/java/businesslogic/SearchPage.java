package businesslogic;

import objectrepository.SearchPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage extends BasePage {
    SearchPageObjects searchPageObjects = new SearchPageObjects();

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, searchPageObjects);
    }

    public String searchResultHeadingProductName() {
        waitForVisibilityOfElement(searchPageObjects.getSearchResultHeadingItemName());
        return searchPageObjects.getSearchResultHeadingItemName().getText();
    }
    public String getFirstSearchResultProductName(){
        waitForPageToLoad(driver, 10);
        Assert.assertTrue(searchPageObjects.getSearchedItemNames().size()>0, "Search result item size is 0");
        return searchPageObjects.getSearchedItemNames().get(0).getText().toLowerCase();
    }
}

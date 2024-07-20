package businesslogic;

import constants.Filters;
import objectrepository.PhoneAccePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PhoneAcceLib extends BasePage {
    PhoneAccePageObjects pa = new PhoneAccePageObjects();

    public PhoneAcceLib(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, pa);
    }

    public void waitForCellPhoneAccessoriesPageToBeDisplayed() {
        waitForVisibilityOfElement(pa.getCellPhoneAndSmartPhoneLink());
        pa.getCellPhoneAndSmartPhoneLink().click();
    }

    public void moveToAllFiltersAndClick() {
        scrollToElement(pa.getAllFiltersBtn());
        waitForVisibilityOfElement(pa.getAllFiltersBtn());
        pa.getAllFiltersBtn().click();
    }

    public void selectCondition(String conditionType) {
        WebElement element = driver.findElement(pa.selectConditionCategory(conditionType));
        element.click();
        delay(2);
    }

    public void moveToFilterAndSelectSingleCategory(Filters filterType) {

        WebElement element = driver.findElement(pa.applyFiltering(filterType.getFilterType()));
        moveToElementAndCLick(element);
        switch (filterType) {
            case Price:
                enterMaxPrice(Integer.valueOf(filterType.getFilterValue()));
                break;
            case Location:
                selectLocation(filterType.getFilterValue());
                break;
            case Condition:
                selectCondition(filterType.getFilterValue());
                break;
        }
    }

    public void enterMaxPrice(int maxValue) {
        pa.getMaxAmountTextBox().sendKeys(String.valueOf(maxValue));
        delay(2);
    }

    public void selectLocation(String location) {
        WebElement element = driver.findElement(pa.selectItemLocation(location));
        jsClick(element);
        delay(2);
    }

    public boolean assertAppliedFilterValues(String condition) {
        WebElement element = driver.findElement(pa.validateFiltersApplied(condition));
        return isElementVisible(element);
    }

    public void clickOnApplyFilter() {
        pa.getApplyFilterButton().click();
    }
    public void tapOnFiltersAppliedBtn(){
        waitForVisibilityOfElement(pa.getAppliedFilterBtnText());
        jsClick(pa.getAppliedFilterBtnText());
        moveToElement(pa.getClearAllBtn());
    }

    public void assertAppliedFilterCountPage(int expectedCount) {
        waitForVisibilityOfElement(pa.getAppliedFilterBtnText());
        Assert.assertEquals(pa.getAppliedFilterBtnText().getText(), String.valueOf(expectedCount) + " filters applied", "Invalid number of filters applied");
    }

    public void assertSelectedFiltersAndValuesAppliedDisplaying(Filters filter) {
        waitForVisibilityOfElement(pa.getClearAllBtn());
        WebElement element = driver.findElement(pa.appliedFilterName(filter));
        Assert.assertTrue(element.getText().contains(filter.getFilterValue()), "Filter value doesn't match for " + filter);
    }
}



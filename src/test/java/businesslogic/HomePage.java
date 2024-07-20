package businesslogic;

import objectrepository.HomePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    HomePageObjects hp = new HomePageObjects();

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, hp);
    }
    public void clickOnHeader() {
        waitForVisibilityOfElement(hp.getShopByCategoryDD());
        hp.getShopByCategoryDD().click();
    }
    public void moveToAccessoriesNCLick(){
        waitForVisibilityOfElement(hp.getCellPhoneAccessTab());
        moveToElementAndCLick(hp.getCellPhoneAccessTab());
    }
    public void inputSearchProductName(String searchItem){
        waitForVisibilityOfElement(hp.getSearchBar());
        hp.getSearchBar().sendKeys(searchItem);
    }
    public void selectCategory(String value){
        selectVisibleTextFromDropDown(hp.getCategoriesDropDown(),value);
    }
    public void clickOnSearchButton(){
        hp.getSearchBtn().click();
    }
}

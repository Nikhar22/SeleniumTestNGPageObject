package businesslogic;

import config.CommonActions;
import org.openqa.selenium.WebDriver;

public class BasePage extends CommonActions {

    HomePage homePage;
    PhoneAcceLib phoneAcceLib;
    SearchPage searchPage;
    public BasePage(WebDriver driver) {
        super(driver);
    }
    public HomePage getHomePage(){
        this.homePage = new HomePage(this.driver);
        return this.homePage;
    }
    public PhoneAcceLib getPhoneAccePage(){
        this.phoneAcceLib = new PhoneAcceLib(this.driver);
        return this.phoneAcceLib;
    }
    public SearchPage getSearchPage(){
        this.searchPage = new SearchPage(this.driver);
        return this.searchPage;
    }


}

package objectrepository;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePageObjects {

    @FindBy(id="gh-shop-ei")
    private WebElement shopByCategoryDD;
    @FindBy(xpath="//a[text()= 'Cell phones & accessories']")
    private WebElement cellPhoneAccessTab;
    @FindBy(id="gh-ac")
    private WebElement searchBar;
    @FindBy(id="gh-cat")
    private WebElement categoriesDropDown;
    @FindBy(id="gh-btn")
    private WebElement searchBtn;
}

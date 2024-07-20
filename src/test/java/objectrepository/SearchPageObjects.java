package objectrepository;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class SearchPageObjects {
    @FindBy(xpath = "//h1[contains(@class, 'heading')]//span[2]")
    private WebElement searchResultHeadingItemName;
    @FindBy(xpath = "//div[@id='srp-river-results']//li[@class='s-item s-item__pl-on-bottom']//a[@class='s-item__link']//span[@role='heading']")
    private List<WebElement> searchedItemNames;

}

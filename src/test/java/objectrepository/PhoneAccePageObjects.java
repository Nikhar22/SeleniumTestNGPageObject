package objectrepository;

import constants.Filters;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class PhoneAccePageObjects {

    @FindBy(linkText = "Cell Phones & Smartphones")
    private WebElement cellPhoneAndSmartPhoneLink;

    @FindBy(xpath = "//button[text()='All Filters']")
    private WebElement allFiltersBtn;

    @FindBy(className = "x-overlay__container")
    private WebElement allFilterPopUp;

    @FindBy(xpath = "//div[contains(@id, 'mainPanel-condition')]")
    private WebElement conditionFilter;
    @FindBy(xpath = "//div[contains(@id, 'mainPanel-price')]")
    private WebElement priceFilter;
    @FindBy(xpath = "//input[contains(@aria-label, 'Maximum Value')]")
    private WebElement maxAmountTextBox;
    @FindBy(xpath = "//div[contains(@id, 'mainPanel-location')]")
    private WebElement itemLocationFilter;
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applyFilterButton;
    @FindBy(xpath = "//li[@class='brm__item brm__item--applied']//button/span")
    private WebElement appliedFilterBtnText;
    @FindBy(xpath = "//li[@class='brm__item brm__item--applied']//button//following-sibling::div//a")
    private List<WebElement> allocatedFilters;
    @FindBy(linkText = "Clear All")
    private WebElement clearAllBtn;

    private final String conditionCategory = "//span[text()= '%s']//parent::label[contains(@class, 'multi-select')]";
    private final String itemLocationCategory = "//input[@class='radio__control'][@value='%s']";
    private final String appliedFiltersChips = "//div[@id='c3-tray-tray']//span[contains(text(), '%s')]";
    private final String filterTypes = "//div[contains(@id, 'mainPanel-%s')]";
    private final String appliedFilterNames = "//span[@class='brm__item-label'][contains(text(), '%s')]";
    public By appliedFilterName(Filters value){
        return By.xpath(String.format(appliedFilterNames, value.getAppliedValue()));
    }

    public By applyFiltering(String type){
        return By.xpath(String.format(filterTypes, type));
    }
    public By selectConditionCategory(String name) {
        return By.xpath(String.format(conditionCategory, name));
    }
    public By selectItemLocation(String location){
        return By.xpath(String.format(itemLocationCategory, location));
    }
    public By validateFiltersApplied(String expectedFilterValue){
        return By.xpath(String.format(appliedFiltersChips, expectedFilterValue));
    }
}

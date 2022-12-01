package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;

    @FindBy(xpath= "/html/body/div[1]/div[4]/div[2]/div/div[1]/div/div/div/div[2]/div[4]/form/input[9]")
    WebElement SearchField;

    @FindBy(xpath="/html/body/div[1]/div[4]/div[2]/div/div[1]/div/div/div/div[2]/div[4]/form/button")
    WebElement SearchButton;

    @FindBy(xpath="/html/body/div[1]/div[4]/div[3]/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/a")
    WebElement FilterButton;

    @FindBy(xpath="/html/body/div[1]/div[4]/div[3]/div/div[3]/div/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/ul/li[3]")
    WebElement FilterByHighPrice; // фильтр по убыванию цены


    public MainPage OpenPage()
    {
        driver.get("http://musicmarket.by");
        return this;
    }

    public MainPage OpenPageFilter()
    {
        driver.get("https://musicmarket.by/gitary-i-gitarnoe-oborudovanie/struny-dlya-gitar/struny-dlya-elektrogitary");
        return this;
    }


    public MainPage SearchFor(String searchQuery) {
        Actions builder=new Actions(driver);    // создаем объект Actions
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(SearchField));
        builder.moveToElement(SearchField).click().sendKeys(searchQuery).build().perform();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(SearchButton));
        builder.moveToElement(SearchButton).click().build().perform();
        return this;
    }

    public MainPage SortItems()
    {
        Actions builder = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(FilterButton));
        builder.moveToElement(FilterButton).click().build().perform();
        new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(FilterByHighPrice));
        FilterByHighPrice.click();
        return this;
    }
}

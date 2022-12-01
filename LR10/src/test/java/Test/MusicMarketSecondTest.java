package Test;

import Page.MainPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicMarketSecondTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void TestSearch() {
        var MainPage = new MainPage(driver);
        MainPage.OpenPage();
        MainPage.SearchFor("Струны для электрогитары");
    }

    @Test
    public void TestSort() throws InterruptedException {
        var MainPage = new MainPage(driver);
        MainPage.OpenPageFilter();
        MainPage.SortItems();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div/div[3]/div/div[1]/div/div[2]/div/div[3]/div[1]/div[1]/div/form/div/div[2]/div[1]/a")).click();
    }

    @Test
    public void AllTogether() throws InterruptedException {
        var MainPage = new MainPage(driver);
        MainPage.OpenPage();
        MainPage.SearchFor("Струны для электрогитары");
        MainPage.SortItems();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div/div[3]/div/div[1]/div/div[2]/div/div[3]/div[1]/div[1]/div/form/div/div[2]/div[1]/a")).click();
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}

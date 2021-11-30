package finalProject.pages;

import finalProject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends TestBase {
    private final By productInput = By.id("q");
    private final By searchButton = By.xpath("//i[@class='main-search-submit__icon icon-svg']");
    private final By productLelles = By.xpath("//img[@alt='L.O.L lelles']");
    private final By productAccessories = By.xpath("//img[@alt='Leļļu aksesuāri (Ratiņi, leļļu mājas, apģērbs u.c.)']");
    private final By pickProductCar = By.linkText("Bērnu rotaļu mašīnīte MGA L.O.L. Surprise OMG Glamper");


    public void productSearch(String input) {
        driver.findElement(productInput).sendKeys(input);
    }

    public void searchButtonClick() {
        driver.findElement(searchButton).click();
    }

    public void chooseLelles() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(productLelles));
        driver.findElement(productLelles).click();
    }

    public void chooseAccessories() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(productAccessories));
        driver.findElement(productAccessories).click();
    }

    public void pickProduct() throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js = driver;
        js.executeScript("window.scrollBy(0,700)");
        //Thread.sleep(2000);

        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(pickProductCar));
        driver.findElement(pickProductCar).click();
    }
}

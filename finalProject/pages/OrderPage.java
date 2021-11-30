package finalProject.pages;

import finalProject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage extends TestBase {

    private final By chooseDeliveryType = By.xpath("//input[@type='radio' and @value='2']");
    private final By chooseDeliveryCity = By.xpath("//input[@type='radio' and @value='3543']");

    private final By fillName = By.xpath("//input[@id='address_first_name']");
    private final By fillSurname = By.xpath("//input[@id='address_last_name']");
    private final By fillPhone = By.xpath("//input[@id='address_phone_number']");

    private final By proceedToPayment = By.xpath("//button[@class='main-button upcase fr small-radius button-min-width checkout-shipping-continue-button']");

    public void fillDeliveryDetails() {

        driver.findElement(chooseDeliveryType).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(chooseDeliveryCity));
        driver.findElement(chooseDeliveryCity).click();
    }

    public void custDetailsInput(String userName, String userSurname, String userPhone) {

        driver.findElement(fillName).sendKeys(userName);
        driver.findElement(fillSurname).sendKeys(userSurname);
        driver.findElement(fillPhone).sendKeys(userPhone, Keys.RETURN);
    }

    public void proceedToPayment() throws InterruptedException {

        JavascriptExecutor js = driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(5000);
        driver.findElement(proceedToPayment).click();
    }
}

package finalProject.pages;

import finalProject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPage extends TestBase {

    private final By productName = By.xpath("//*[@class='product-righter google-rich-snippet']/h1");
    private final By productPrice = By.xpath("//*[@class='price']/span");
    private final By addToCart = By.xpath("//button[@id='add_to_cart_btn']");
    private final By proceedToCart = By.xpath("//a[@class='main-button']");
    private final By cartProdName = By.linkText("Bērnu rotaļu mašīnīte MGA L.O.L. Surprise OMG Glamper");
    private final By cartProdPrice = By.xpath("//p[@class='detailed-cart-item__price']");
    private final By proceedToOrder = By.xpath("//input[@type='submit']");

    public void addToCart() {
        driver.findElement(addToCart).click();
    }

    public void settingProductName() {
        product.setProdName(driver.findElement(productName).getText());
    }

    public void settingProductPrice() {
        product.setProdPrice(driver.findElement(productPrice).getText());
    }

    public void proceedToCart() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(proceedToCart));
        driver.findElement(proceedToCart).click();
    }

    public void validationForName() {
        String name = driver.findElement(cartProdName).getText();
        System.out.println("PROD NAME IN THE CART is " + name);
        System.out.println("GET PROD NAME FROM Product.model is " + product.getProdName());
        assertThat(product.getProdName()).isEqualTo(name);
    }

    public void validationForPrice() {
        String price = driver.findElement(cartProdPrice).getText().replace(" €","");
        System.out.println("PROD PRICE IN THE CART is " + price);
        System.out.println("GET PROD PRICE FROM Product.model is " + product.getProdPrice());
        assertThat(product.getProdPrice()).isEqualTo(price);
    }

    public void proceedToOrder() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(proceedToOrder).click();
    }
}


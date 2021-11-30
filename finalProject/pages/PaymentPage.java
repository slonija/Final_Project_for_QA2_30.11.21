package finalProject.pages;

import finalProject.base.TestBase;
import finalProject.models.Customer;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentPage extends TestBase {

    Customer customer = new Customer();

    private final By choosePaymentType = By.xpath("//input[@id='payment_unused_22']");
    private final By validCustName = By.xpath("//div[@class='name']");
    private final By validCustPhone = By.xpath("//div[@class='address']");

    public void choosePaymentType() {

        driver.findElement(choosePaymentType).click();}

    public void validationForCustomerName() {
        String customerName = driver.findElement(validCustName).getText();
        String modelCustName = customer.getCustName() + " " + customer.getCustSurname();
        assertThat(modelCustName).isEqualTo(customerName);
    }

    public void validationForCustomerPhone() {
        String customerPhone = driver.findElement(validCustPhone).getText().substring(0,8);
        assertThat(customer.getCustPhone()).isEqualTo(customerPhone);
    }

}
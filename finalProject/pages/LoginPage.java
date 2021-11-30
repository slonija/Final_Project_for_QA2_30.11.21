package finalProject.pages;

import finalProject.base.TestBase;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends TestBase {

    private final By custEmailInput = By.xpath("//form[@id='new_user_guest'] //input[@class='users-session-form__input users-session-form__input--text']");
    private final By proceedToOrderPage = By.xpath("//input[@value='Turpināt']");

    public void login(String emailInput) {

        driver.findElement(custEmailInput).sendKeys(emailInput);
        driver.findElement(proceedToOrderPage).click();
    }
}



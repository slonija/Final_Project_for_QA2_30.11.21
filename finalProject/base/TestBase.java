package finalProject.base;

import finalProject.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public static ChromeDriver driver;
    public Product product = new Product();

    public void startDriver() {

        String driverPath = "C:\\QA\\QA2\\IdeaProjects\\LectureProjectForQA2\\src\\test\\resources\\";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.1a.lv/");
        driver.manage().window().maximize();
    }

    public void acceptCookies() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")));
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("Akceptēt visu")));
        driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
    }

    public void stopDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
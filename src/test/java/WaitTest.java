import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class WaitTest {
    WebDriver driver;
    @BeforeMethod
    public void open() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Test2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.id("startStopButton")).click();
        WebElement percentage = driver.findElement(By.xpath("//*[@role='progressbar']"));
        wait.until(ExpectedConditions.domAttributeToBe(percentage,"aria-valuenow","50"));
        System.out.println(percentage.getText());
    }
}

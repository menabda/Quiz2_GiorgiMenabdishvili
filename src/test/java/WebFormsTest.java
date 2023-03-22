import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebFormsTest {
    WebDriver driver;
    @BeforeMethod
    public void open() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Task2(){
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Select SQL = new  Select(driver.findElement(By.id("dropdowm-menu-1")));
        SQL.selectByVisibleText("SQL");
        List<WebElement> checkBoxes= driver.findElements(By.xpath("//*[@type='checkbox']"));
        for (WebElement checkbox:checkBoxes) {
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }
        WebElement yellow = driver.findElement(By.xpath("//*[@value='yellow']"));
        yellow.click();
        WebElement orange = driver.findElement(By.xpath("//*[@id='fruit-selects']/option[@value='orange']"));
        Assert.assertFalse(orange.isEnabled());
    }

}

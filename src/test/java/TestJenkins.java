import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class TestJenkins {
    private WebDriver driver;
    @Test
    public void testQAEnv(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String header= driver.findElement(By.xpath("//div[@class='sign-in-title']/h3")).getText().trim();
        AssertJUnit.assertTrue(header.equals("Sign in"));
//        Assert.assertEquals(header,"Sign in");
    }

    @BeforeTest
    public void beforeTest(){
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        driver=new ChromeDriver();
//        driver.get("https://fmsi-oacqa.kronos.com/OACWEB/#/home");
//        driver.manage().window().maximize();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.get("https://fmsi-oacqa.kronos.com/OACWEB/#/home");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}

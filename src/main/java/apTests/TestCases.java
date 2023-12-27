
package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.get("https://www.amazon.in/");
        String cu= driver.getCurrentUrl();
        if(cu.contains("amazon"))
        {
            System.out.println("Navigated to a proper website");
        }
        System.out.println("end Test case: testCase01");
    }
    public void testCase02() {
        System.out.println("Start Test case: testCase02");
        WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
        ele.sendKeys("laptop");
        WebElement bu= driver.findElement(By.id("nav-search-submit-button"));
        bu.click();
        String lap;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Wait done");



        List <WebElement> lis = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
        System.out.println("The size of the list is: "+lis.size());
           for(WebElement el:lis)
           {
            lap=el.getText(); 
            if(lap.contains("laptop")||lap.contains("Laptop"))
            {
                System.out.println("Text: Laptop");// check here if fails
                break;
            }
           }

        System.out.println("end Test case: testCase02");

        
    }
    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.amazon.in/");
         WebElement elect= driver.findElement(By.xpath("//a[text()=' Electronics ']"));
         elect.click();
         String elecurl=driver.getCurrentUrl();
         if(elecurl.contains("electronics"))
         {
            System.out.println("URL: "+elecurl);
         }
        System.out.println("end Test case: testCase03");
       
    }

}


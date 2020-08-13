import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BambooTest
{
    //public static final By TRY_LINK = By.xpath("//div[@id='mainNav']/ul/li/a[contains(@href, 'try')]");
    public static final By App_Header = By.linkText("Online Demo Shopping App");
    public static final By Electronics_Link = By.linkText("Electronics");
    public static final By Cart_Value = By.cssSelector(".badge");
    public static final By Gadget1 = By.cssSelector(".col-md-4:nth-child(2) #product");
    public static final By Gadget2 = By.cssSelector(".col-md-4:nth-child(3) #product");
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @Before
    
    public void setUp() throws Exception
    {
    	System.setProperty("webdriver.gecko.driver", "C:\\Tests\\firefox\\geckodriver.exe");
    	driver = new FirefoxDriver();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://localhost:8008");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testApp() throws Exception
    {
        WebElement app_Header = driver.findElement(App_Header);
        assertEquals("'Check' Header has correct label", "Online Demo Shopping App", app_Header.getText());
    } 
    @Test
    public void addCart()throws Exception
    {
    	Actions action = new Actions(driver);
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	WebElement electronics_Link = driver.findElement(Electronics_Link);
        electronics_Link.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement cart_Value = driver.findElement(Cart_Value);
        int initial_CartVal = Integer.parseInt(cart_Value.getText());
        System.out.println(initial_CartVal);
        assertEquals("'Cart Value' Initial Cart value", 0, initial_CartVal);
        WebElement gadget1 = driver.findElement(Gadget1);
        Thread.sleep(5000);
        action.moveToElement(gadget1).build().perform();
        Thread.sleep(5000);
        gadget1.click();
        Thread.sleep(5000);
        WebElement gadget2 = driver.findElement(Gadget2); 
        Thread.sleep(5000);
        action.moveToElement(gadget2).build().perform();
        Thread.sleep(5000);
        gadget2.click();  
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        int final_CartVal = Integer.parseInt(cart_Value.getText());
        assertEquals("'Cart Value' Final Cart value", 2, final_CartVal);
        
    }
    
    /*
    * Closes the browser
    */
    @After
    public void quitDriver() throws Exception{
    Thread.sleep(3000);
    driver.quit();
    } // end of method quitDriver
}

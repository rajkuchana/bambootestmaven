import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class BambooTest
{
    public static final By TRY_LINK = By.xpath("//div[@id='mainNav']/ul/li/a[contains(@href, 'try')]");
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException
    {
        driver = new HtmlUnitDriver(false);
        driver.get("https://www.atlassian.com/");
    }

    @Test
    public void testGoogle()
    {
        WebElement tryLink = driver.findElement(TRY_LINK);
        assertEquals("'Try' link has wrong label", "Try", tryLink.getText());
    }
}

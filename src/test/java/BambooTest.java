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
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException
    {
        driver = new HtmlUnitDriver(false);
    }

    @Test
    public void testGoogle()
    {
        driver.get("https://www.atlassian.com/");
        WebElement tryLink = driver.findElement(By.xpath("//div[@id='mainNav']/ul/li/a[contains(@href, 'try')]"));

        assertEquals("It looks Try link has wrong label", "Try", tryLink.getText());
    }
}

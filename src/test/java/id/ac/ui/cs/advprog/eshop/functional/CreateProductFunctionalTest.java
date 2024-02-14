package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Value;




import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;
    private String baseUrl;


    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d/product/create", testBaseUrl, serverPort);
    }

    @Test
    void testNameInteraction(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.clear();

        String testProductName = "Test Product Name";
        nameInput.sendKeys(testProductName);

        String nameData = nameInput.getAttribute("value");
        assertEquals(testProductName, nameData);

        nameInput.clear();
        nameData = nameInput.getAttribute("value");
        assertEquals("", nameData);
    }
    @Test
    void testQuantityInteraction(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.clear();

        String testQuantity = "100";
        quantityInput.sendKeys(testQuantity);

        String quantityData = quantityInput.getAttribute("value");
        assertEquals(testQuantity, quantityData);

        quantityInput.clear();
        quantityData = quantityInput.getAttribute("value");
        assertEquals("", quantityData);
    }

    @Test
    void verifyPageTitle(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        assertEquals("Create New Product", pageTitle);
    }

    @Test
    void verifyHeader(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String headerText = driver.findElement(By.tagName("h3")).getText();

        assertEquals("Create New Product", headerText);
    }



}

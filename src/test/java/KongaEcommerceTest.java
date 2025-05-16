import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.lang.InterruptedException;



public class KongaEcommerceTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1.Open Chrome Browser
        driver = new ChromeDriver();
        //2.Visit the URL konga
        //Enter Url link in the address bar in the Chrome browser
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
    }

    @Test
    public void ClickSignIn() throws InterruptedException {
        //3.Sign in to Konga successfully
        //Locate and click on the login/SignUp menu on the Homepage
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div[4]/a")).click();
        //Enter your Valid Email Address or Phone Number in the Email Address or Phone Numbers field
        driver.findElement(By.name("username")).sendKeys("09169871439");
        //Locate password field and input valid password
        driver.findElement(By.name("password")).sendKeys("Aderuth@01");
        //Click on the login button and redirect to Konga Dashboard
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/div/aside/div[2]/div/form/div[3]/button")).click();

        //4.From the categories,click on the computers and accessories
        //create the action object
        Actions action = new Actions(driver);
        //Hover over "All categories"
        WebElement categoryMenu = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]"));
        action.moveToElement(categoryMenu).perform();
        Thread.sleep(2000);
        //Hover and click "Computers and Accessories"
        WebElement computersAndAccessories = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        action.moveToElement(computersAndAccessories).click().perform();
        Thread.sleep(10000);

        //5.Click on the Laptops Subcategory
        //locate laptops subcategory and click
        WebElement SubcategoryMenu = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span"));
        SubcategoryMenu.click();
        Thread.sleep(5000);
        //6.Click on the Apple MacBooks
        //locate Apple MacBooks and click
        WebElement macbooksCheckbox = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span"));
        macbooksCheckbox.click();
        Thread.sleep(5000);


        //7.Add an item to the cart
        //Locate an item and click on it
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/section/section/ul/li[2]/article/div[1]/a[1]/picture/img")).click();
        Thread.sleep(5000);
        // Click on the add to cart button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(5000);

        //8.Select Address
        //Locate and click on continue to Checkout button
        WebElement CheckoutButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]/a"));
        CheckoutButton.click();
        //Locate and click on Add delivery address
        WebElement DeliveryAddress = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button"));
        DeliveryAddress.click();
        //Locate and click on "address" button
        WebElement Address = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/div/aside/div[2]/div/div/div[2]/div[1]/form/button"));
        Address.click();
        Thread.sleep(5000);
        //Locate and click on "Use this address" button to select address
        WebElement UseAddress = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/div/aside/div[3]/div/div/div/a"));
        UseAddress.click();

        //9.Continue to make payment
        //locate "Pay Now" on Payment Option and click button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        // Locate "Continue to Payment" button and click
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[4]/div[2]/div/button")).click();

        //10.Select a card payment method
        //Locate "Card" method on select payment method and click
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/div/div[2]/div/div[3]/button")).click();

        //11.Input invalid card details
        //Input invalid card number
        driver.findElement(By.id("card-number")).sendKeys("1234567890123456");
        //Input invalid date
        driver.findElement(By.id("expiry")).sendKeys("06/26");
        // Input invalid CVV number
        driver.findElement(By.id("cvv")).sendKeys("123");

        //12.Input invalid card pin
        //Locate card pin placeholder and click on the invalid pin(4321)
        driver.findElement(By.id("card-pin-new")).getText();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[11]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[8]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[5]")).click();

        //13.Print out the error message:invalid card number
        //Locate the error messsage element and gets it text
        String errorMessage = driver.findElement(By.id("card-number_unhappy")).getText();
        //Print the error message
        System.out.println("Error message displayed: " + errorMessage);

        //14.Close the iFrame that displays the input card modal
        //locate the close button on card details modal and click
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();

    }

    @AfterTest
    //15.Quit the browser
    //Descriptive comment:close browser
    public void closeBrowser() {
        driver.quit();
    }

}

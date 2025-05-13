import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KongaEcommerceTest {
    //import the selenium WebDriver
private WebDriver driver;

public void start() throws InterruptedException {
    //locate where the chromedriver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //1.Open Chrome Browser
    //Descriptive comment:Launch the Chrome browser
    driver = new ChromeDriver();

    //2.Visit the URL konga
    //Descriptive comment:Enter Url link in the address bar in the Chrome browser
    driver.get("https://www.konga.com/");
    Thread.sleep(5000);

    //3.Sign in to Konga successfully
    //Descriptive comment:Locate and click on the login/SignUp menu on the Homepage
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div[4]/a")).click();
    //Descriptive comment:Enter your Valid Email Address or Phone Number in the Email Address or Phone Numbers field
    driver.findElement(By.name("username")).sendKeys("09169871439");
    //Descriptive comment:Locate password field and input valid password
    driver.findElement(By.name("password")).sendKeys("Aderuth@01");
    //Descriptive comment:Click on the login button and redirect to Konga Dashboard
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/div/aside/div[2]/div/form/div[3]/button")).click();
    Thread.sleep(10000);

    //4.From the categories,click on the computers and accessories
    //Locate all categories on the dashboard
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]"));
    //locate and click computers and accessories category
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
    Thread.sleep(5000);

    //5.Click on the Laptops Subcategory
    //Descriptive comment: locate laptops subcategory and click
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a")).click();
    Thread.sleep(5000);

    //6.Click on the Apple MacBooks
    //Descriptive comment:locate Apple MacBooks and click
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
    Thread.sleep(5000);

    //7.Add an item to the cart
    //Descriptive comment: Locate an item and click on it
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/section/section/ul/li[2]/article/div[1]/a[1]/picture/img")).click();
    // Click on the add to cart button
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div/div[2]/div[2]/form/div[5]/div[1]/button")).click();

    //8.Select Address
    //Descriptive comment:Locate and click on continue to Checkout button
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]/a")).click();
    //Locate and click on Add delivery address
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
    //Locate and click on "address" button
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/div/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
    //Locate and click on "Use this address" button to select address
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/div/aside/div[3]/div/div/div/a")).click();
    Thread.sleep(10000);

    //9.Continue to make payment
    //Descriptive comment: locate "Pay Now" on Payment Option and click button
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
    // Locate "Continue to Payment" button and click
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[4]/div[2]/div/button")).click();

    //10.Select a card payment method
    //Descriptive comment: Locate "Card" method on select payment method and click
    driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/div/div[2]/div/div[3]/button")).click();

    //11.Input invalid card details
    //Descriptive comment:Input invalid card number
    driver.findElement(By.id("card-number")).sendKeys("1234567890123456");
    //Input invalid date
    driver.findElement(By.id("expiry")).sendKeys("06/26");
    // Input invalid CVV number
    driver.findElement(By.id("cvv")).sendKeys("123");

    //12.Input invalid card pin
    //Descriptive comment: Locate card pin placeholder and click on the invalid pin(4321)
    driver.findElement(By.id("card-pin-new"));
    driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
    driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[11]")).click();
    driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[8]")).click();
    driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[5]")).click();
    Thread.sleep(5000);

    //13.Print out the error message:invalid card number
    //Descriptive comment:Locate error message : invalid card number
    driver.findElement(By.id("card-number_unhappy"));

    //14.Close the iFrame that displays the input card modal
    //Descriptive comment:locate the close button on card details modal and click
    driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();

    //15.Quit the browser
    //Descriptive comment:close browser
    driver.quit();

}

package initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Setup {
    public static WebDriver driver = null;

    //connection to platfrom and browser
    public static WebDriver SetupDriver(String platfrom, String url, String browser) {
        if (platfrom.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            //if platfrom is windows
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\Googlee\\src\\main\\resources\\driver\\chromedriver_win32\\chromedriver.exe");
        } else {
            //if the platfrom is not windows
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\Googlee\\src\\main\\resources\\driver\\chromedriver_win32\\chromedriver");
        }
        //connect to webdriver interface and create a object to choredriver class
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //making window size maximize
        driver.manage().window().maximize();
        //fetting url from main method to platfrom
        driver.get(url);
        return driver;
    }

    @AfterTest
    public void quitdriver() {
        driver.quit();
    }


    //giving platfrom and url
    @Test
    public void facebooklogin() {


        SetupDriver("windows", "https://www.facebook.com/", "chrome");


        //driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")) .sendKeys("fortnite");
        //driver.get("https://www.facebook.com");
        //typing email
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("ahmed@gmail.com");
        //typing password
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("asdfghjk");
        //click on log inn botton
        driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
        //try and cathchig exeption

        //for exit browser

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //dont want to see any print exeption
        }
    }

    @Test
    public void messangerRediraction() {
        SetupDriver("windows", "https://www.facebook.com/", "chrome");
        driver.findElement(By.linkText("messanger")).click();
        //driver.quit();



    }
}
package ebay;

import initialization.Setup;

import org.openqa.selenium.By;

import org.testng.annotations.Test;



public class HomePage extends Setup {
    public static void main(String[] args) {


        //driver.close();



    }
    @Test
    public void selectItem(){
        SetupDriver("windows","https://www.ebay.com","gecko");
        driver.findElement(By.xpath("//*[@class='hl-popular-destinations-name']")).click();
        driver.findElement(By.xpath("//*[@type='checkbox']")).click();
        driver.findElement(By.xpath("//*[@class='s-item__image-img']")).click();
        driver.findElement(By.xpath("//*[@class='qtyInput']")).clear();

        driver.findElement(By.xpath("//*[@class='qtyInput']")).sendKeys("5");
        //driver.quit();

    }


    @Test
    public void singIn(){
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.xpath("//*[@id='gh-ug']")).click();
        driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("ahmedshowrov21@gmail.com");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("qwertyuio");
        driver.findElement(By.xpath("//*[@id='sgnBt']")).click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = ("https://www.ebay.com/signin/s");
        if(actualUrl.equalsIgnoreCase(expectedUrl)){
            System.out.println("passed");
        }else
            System.out.println("Failed");


        //driver.navigate().back();
        //driver.navigate().forward();
        driver.findElement(By.xpath("//*[@id='gh-la']")).click();
        driver.navigate().refresh();
        //driver.quit();



    }
    @Test
    public void search(){
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.xpath("//*[@id='gh-cat']")).sendKeys("cameras");
        driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
        driver.findElement(By.xpath("//*[@class='svg-icon']")).click();
        driver.findElement(By.xpath("//*[@href='https://www.ebay.com/b/Canon-Digital-Cameras/31388/bn_740']")).click();
        String actualTitle = driver.getTitle();
        String expactedTitle="Canon Digital Cameras for sale | eBay";
        if(actualTitle.equalsIgnoreCase(expactedTitle)){
            System.out.println("passed");
        }else
            System.out.println("failed");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='gh-la']")).click();
        //driver.quit();


    }





}

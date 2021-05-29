package io.wax.atomichub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    public ChromeDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jasos\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("test start");
    }

    @Test
    public void titleTest(){
        driver.get("https://wax.atomichub.io/");
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/span/a/img"));
    }

    @Test
    public void searchTest(){
        driver.get("https://wax.atomichub.io/market");
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[1]/div/div[3]/form/input")).sendKeys("mlb.topps");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[1]/div/div[3]/form/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[1]/div/div[3]/div/div/div[2]/button")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[1]/div/div[3]/div/div/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[2]/div[3]/form/input")).sendKeys("opening");
    }

    @Test
    public void sortTest(){
        driver.get("https://wax.atomichub.io/market");
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/button[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[1]/div/div[3]/div/div/div[2]/button")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[1]/div/div[3]/div/div[1]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[2]/div[3]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[2]/div[3]/div/div/a[3]")).click();
        WebDriverWait waitForElem = new WebDriverWait(driver, 3);
        waitForElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[2]/div[4]/div/div[1]/div[2]/div[2]/div[2]/span")));
        String firstPrice = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[2]/div[4]/div/div[1]/div[2]/div[2]/div[2]/span")).getText();
        System.out.println(firstPrice);
    }



    @Test
    public void txTest(){
        driver.get("https://wax.atomichub.io/");
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div[2]/div/div/div/div[3]/table/tbody/tr/td[2]"));
    }

    @After
    public void close(){
        System.out.println("test close");
        driver.quit();
    }
}

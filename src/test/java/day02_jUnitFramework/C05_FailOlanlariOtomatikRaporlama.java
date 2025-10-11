package day02_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;

public class C05_FailOlanlariOtomatikRaporlama {

    /*
        JUnit testlerin passed/failed oldugunu otomatik olarak raporlar
        test methodu passed olursa  yesil tik
                     failed olursa  kirmizi x
                     ignore olursa  gri bir cember ve uzerine capraz tek cizgi
        ile testlerin durumunu raporlar

        JUnit'in bir testi FAILED olarak isaretlemesi icin
        kodun hata vermesi ve exception firlatmasi gerekir

     */

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("setup calisti");
    }

    @AfterEach
    public void teardown(){
        System.out.println("teardown calisti");
        driver.quit();
    }

    @Test
    public void testotomasyonuTesti() throws InterruptedException {
        // 1.method testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(2000);
        // title'in Test Otomasyonu icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        } else {
            System.out.println("Testotomasyonu testi FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void wisequarterTesti(){
        // 2.method wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //  url'in wisequarter icerdigini test edin
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else {
            System.out.println("Wisequarter testi FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void jUnitTesti(){
        // 3.method junit.org adresine gidin
        driver.get("https://www.junit.org");

        //   url'in "https://junit.org/junit5/" oldugunu test edin
        String expectedUrl = "https://junit.org/junit5/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("JUnit testi PASSED");
        } else {
            System.out.println("JUnit testi FAILED");
            throw new AssertionFailedError();
        }
    }
}

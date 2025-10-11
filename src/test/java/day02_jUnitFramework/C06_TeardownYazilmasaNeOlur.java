package day02_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;

public class C06_TeardownYazilmasaNeOlur {

    /*
        driver.quit() ayri bir method yapilmazsa
        test failed olup exception firlatildiginda
        kodlarin calismasi duracagi icin
        kod driver.quit()'in oldugu satira gelmez
        browser acik kalir

        ozellikle toplu calistirmalarda bu ciddi sorun olusturabilir

        SONUC:
        her ne kadar tek bir satiri calistiriyor olsa da
        teardown method'u olusturmak daha mantiklidir.
     */

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
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

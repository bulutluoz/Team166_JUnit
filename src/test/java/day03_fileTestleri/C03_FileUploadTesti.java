package day03_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_FileUploadTesti extends TestBase_Each {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istedigimiz download klasorundeki logo.jpeg dosyasini secelim.

        /*
            Selenium dosya seciminde
            bilgisayarimizdaki klasor yapisini tiklayamayacagi icin
            bir yontem gelistirmis

            Choose butonuna basip, dosyayi secmek yerine
            Selenium ile choose butonunu locate edip
            yuklemek istedigimiz dosyanin DOSYA YOLUNU
            sendKeys ile locate ettigimiz choose butonuna yollayabiliriz
         */

        WebElement chooseButonu = driver.findElement(By.id("file-upload"));
        String dosyaYolu = "/Users/ahmetbulutluoz/Downloads/logo.jpeg";

        chooseButonu.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadYaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "File Uploaded!";
        String actualYazi = fileUploadYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        ReusableMethods.bekle(5);
    }
}

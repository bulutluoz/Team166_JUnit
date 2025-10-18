package day03_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase_Each {

    @Test
    public void test01(){
        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //2. logo.jpeg dosyasını indirelim
        driver.findElement(By.linkText("logo.jpeg"))
                .click();


        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim
        //   indirme linkine tikladigimiz indirme islemi baslatilir
        //   ammmmaaa hemen sonuclanmaz
        //   testinize indirme isleminin tamamlanmasi icin biraz zaman tanimaliyiz
        ReusableMethods.bekle(1);

        String dosyaYolu = "/Users/ahmetbulutluoz/Downloads/logo.jpeg";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}

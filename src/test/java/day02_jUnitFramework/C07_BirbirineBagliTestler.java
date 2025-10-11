package day02_jUnitFramework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_BirbirineBagliTestler {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
        JUnit test method'larinin calisma sirasi konusunda
        herhangi bir yontem belirlememistir
        Yani test method'larini kafasina gore bir siralama ile calistirir

        Bu class'daki gorevde oldugu gibi
        test method'larinin sirali calismasi onemli ise
        o zaman method isimlerini test01, test02, test03.... yapmalisiniz
     */

    /*
        @BeforeEach ve @AfterEach
        isminden anlasilacagi uzere
        HER BIR method'dan once browser'i acar ve
        HER BIR method'dan sonra browser'i kapatir

        Bu class'daki gorevde oldugu gibi
        browser'in EN BASTA acilmasi
        tum method'larin calismasi
        ve EN SONDA browser'in kapanmasi gerekiyorsa

        @BeforeAll ve @AfterAll

        ONEMLI NOT :
        @BeforeAll ve @AfterAll kullanan method'lar
        static olmak zorundadir
     */

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //    Url'in testotomasyonu icerdigini test edin

        String expectedurlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedurlIcerik)){
            System.out.println("Url testi PASSED");
        }
    }

    @Test
    public void test02(){
        // 2- phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@class='prod-img']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        if (actualSonucSayisi>0){
            System.out.println("phone arama testi PASSED");
        } else System.out.println("phone arama testi FAILED");


    }

    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(2000);
        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsim = ilkUrunIsimElementi.getText()
                .toLowerCase(); // case sensitive olmamasi icin


        if(actualIsim.contains(expectedIsimIcerik)){
            System.out.println("Urun isim testi PASSED");
        } else System.out.println("Urun isim testi FAILED");


    }

}

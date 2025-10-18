package day03_fileTestleri;

import org.junit.jupiter.api.Test;

public class C04_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){
        /*
            Onceki class'larda
            iki konumda bulunan dosyalarla ilgili testler yaptik
            1- projenin altinda
                /Users/ahmetbulutluoz/Desktop/MyDesktop/course/projeler/Team166_JunitFramework/src/test/java/day03_fileTestleri/deneme.txt
            2- downloads altinda
                /Users/ahmetbulutluoz/Downloads/logo.jpeg

            Bu dosya yollari kisiden kisiye, bilgisayardan bilgisayara degisir

            bu durumda yazdigimiz test sadece yazildigi bilgisayarda calisir
            baska hic bir bilgisayarda direkt calismaz
            MUTLAKA dosya yolunu duzeltmek gerekir.

            Kodun her bilgisayar icin calismasi istenirse
            Dosya yolu DINAMIK HALE getirilmelidir.

            Java bu konuda da bize yardimci olur
            Java 2 dosya konumunu bize veren hazir method olusturmus
            1- icinde bulundugumuz projenin dosya yolu
            2- bilgisayarin ana dosya yapisi

         */


        // 1- icinde bulundugumuz projenin dosya yolu

        System.out.println(  System.getProperty("user.dir") );
        //     /Users/ahmetbulutluoz/Desktop/MyDesktop/course/projeler/Team166_JunitFramework ==> her bilgisayarda farkli
        //     /src/test/java/day03_fileTestleri/deneme.txt  ==> her bilgisayarda ayni



        // 2- bilgisayarin ana dosya yapisi
        System.out.println(  System.getProperty("user.home"));
        //    /Users/ahmetbulutluoz   ==> her bilgisayarda farkli
        //    /downloads/logo.jpeg    ==> her bilgisayarda ayni


        // proje altindaki dosya icin DINAMIK dosya yolu

        //  /Users/ahmetbulutluoz/Desktop/MyDesktop/course/projeler/Team166_JunitFramework/src/test/java/day03_fileTestleri/deneme.txt
        String dinamikProjedekiDosyaYolu = System.getProperty("user.dir") + "/src/test/java/day03_fileTestleri/deneme.txt";



        // downloads veya desktop altindaki dosya icin dinamik dosya yolu
        // /Users/ahmetbulutluoz/Downloads/logo.jpeg

        String dinamikDowloadsIcindekiDosyaYolu = System.getProperty("user.home") + "/Downloads/logo.jpeg";
        String dinamikDesktopAltindakiDosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";


        // gormek icin dinamik dosya yollarini yazdiralim
        System.out.println(dinamikProjedekiDosyaYolu);

        System.out.println(dinamikDowloadsIcindekiDosyaYolu);

        System.out.println(dinamikDesktopAltindakiDosyaYolu);



    }
}

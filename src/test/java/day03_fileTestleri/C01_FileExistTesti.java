package day03_fileTestleri;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistTesti {

    @Test
    public void fileTesti(){
        // day03 package'i altinda deneme.txt isminde bir dosya bulundugunu test edin

        // Selenium'da biz tum islemlerimizi WebDriver ile yapiyoruz
        // WebDriver adindan da anlasilacagi gibi WEB uzerinde calisir,
        // deneme dosyasi fiziki olarak bizim bilgisayarimizda oldugundan, webDriver deneme dosyasina ulasamaz
        // Eger bilgisayarimda var olan bir dosyaya erismek/kullanmak isterseniz
        // Java'dan yardim almamiz gerekir

        // Adim 1- varligini test edeceginiz dosyanin DOSYA YOLUNU String olarak kaydedin
        String dosyaYolu = "/Users/ahmetbulutluoz/Desktop/MyDesktop/course/projeler/Team166_JunitFramework/src/test/java/day03_fileTestleri/deneme.txt";

        // 2.adim dosyanin belirtilen dosya yolunda varoldugunu test etmek icin

        System.out.println(Files.exists(Paths.get(dosyaYolu))); // true

        String dosyaYoluYanlis1 = "/Users/ahmetbulutluoz/Desktop/MyDesktop/projeler/Team166_JunitFramework/src/test/java/day03_fileTestleri/deneme.txt";
        String dosyaYoluYanlis2 = "/Users/ahmetbulutluoz/Desktop/MyDesktop/course/projeler/Team166_JunitFramework/src/test/java/day03_fileTestleri/dene.txt";
        String dosyaYoluYanlis3 = "/Users/ahmetbulutluoz/Desktop/MyDesktop/course/projeler/Team166_JunitFramework/src/test/java/day03_fileTestleri/deneme.xlsx";

        System.out.println(Files.exists(Paths.get(dosyaYoluYanlis1))); // false
        System.out.println(Files.exists(Paths.get(dosyaYoluYanlis2))); // false
        System.out.println(Files.exists(Paths.get(dosyaYoluYanlis3))); // false


    }
}

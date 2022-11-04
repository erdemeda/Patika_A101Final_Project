package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.Set;
import static utilities.ReusableMethods.jsClick;
import static utilities.ReusableMethods.waitForVisibility;

public class TestCase1_2 {
    HepsiBuradaPage hepsiburadaPage = new HepsiBuradaPage();
    Actions actions = new Actions(Driver.getDriver());
    Logger log = LogManager.getLogger(TestCase1_2.class);
    @Test
    public void test01() {

//1. Kullanıcı girişi yapılarak sepete ürün eklenmesi
        // Kullanıcı Hepsiburada.com sitesini ziyaret eder.
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        // Kullanıcı giriş işlemi yapılır.
        if(hepsiburadaPage.cerezKabulButonu.isDisplayed()){
            jsClick(hepsiburadaPage.cerezKabulButonu);
        }
        actions.moveToElement(hepsiburadaPage.girisYapVeyaUyeOlButonu).perform();
        waitForVisibility(hepsiburadaPage.girisYapButonu1,3);
        hepsiburadaPage.girisYapButonu1.click();
        waitForVisibility(hepsiburadaPage.epostaKutucugu,3);
        hepsiburadaPage.epostaKutucugu.sendKeys("erdemeda073@gmail.com");
        hepsiburadaPage.girisYapButonu2.click();
        hepsiburadaPage.sifreKutucugu.sendKeys("1Hepsiburada");
        hepsiburadaPage.girisYapButonu3.click();
        log.info("Hepsiburada sitesine gidildi");

        // Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
        waitForVisibility(hepsiburadaPage.girisIslemiDogrulamasi,3);
        Assert.assertTrue(hepsiburadaPage.girisIslemiDogrulamasi.isDisplayed());
        log.info("Griris isleminin yapildigi dogrulandi");

        // Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        jsClick(hepsiburadaPage.aramaKutucugu);
        hepsiburadaPage.aramaKutucugu.sendKeys("roman insanlar");
        hepsiburadaPage.araButonu.click();
        log.info("Kullanici satin almak istedigi urun icin arama yapti");

        // Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        waitForVisibility(hepsiburadaPage.insanlarRomaniSayfadakiUrunIsmi,3);
        String romanSayfadakiUrun = hepsiburadaPage.insanlarRomaniSayfadakiUrunIsmi.getText();
        System.out.println("InsanlarRomaniSayfadakiUrun: "+hepsiburadaPage.insanlarRomaniSayfadakiUrunIsmi.getText());
        actions.sendKeys(Keys.ARROW_DOWN)
                .click(hepsiburadaPage.secilecekInsanlarRomani)
                .perform();
        log.info("Kullanici urun listesinden urun secti");

        // Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        Set<String> allWindows=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWH="";

        for (String each: allWindows) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        waitForVisibility(hepsiburadaPage.digerSaticiButonu,3);
        jsClick(hepsiburadaPage.digerSaticiButonu);
        waitForVisibility(hepsiburadaPage.digerSaticilar1,3);
        jsClick(hepsiburadaPage.digerSaticilar1);
        jsClick(hepsiburadaPage.urunSepetinizdeEkraniCikis);
        jsClick(hepsiburadaPage.digerSaticilar2);
        log.info("Secilen urun icin iki farkli saticidan urun secip sepete ekledi");

        // Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        waitForVisibility(hepsiburadaPage.sepeteGitButonu,3);
        jsClick(hepsiburadaPage.sepeteGitButonu);
        waitForVisibility(hepsiburadaPage.insanlarRomaniSepettekiUrunIsmi,3);
        String romanSepettekiUrun = hepsiburadaPage.insanlarRomaniSepettekiUrunIsmi.getText();
        System.out.println("InsanlarRomaniSepettekiUrun: "+hepsiburadaPage.insanlarRomaniSepettekiUrunIsmi.getText());
        Assert.assertEquals(romanSepettekiUrun, romanSayfadakiUrun);
        log.info("Secilen urunun dogru olarak eklendigi ‘Sepetim’ sayfasinda dogrulandi");
        Driver.closeDriver();
        log.info("Sayfa kapatildi");
    }

    @Test
    public void test02() throws InterruptedException {

//2. Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme
        // Kullanıcı Hepsiburada.com sitesini ziyaret eder.
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        log.info("Hepsiburada sitesine gidildi");

        //  Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        if(hepsiburadaPage.cerezKabulButonu.isDisplayed()){
            jsClick(hepsiburadaPage.cerezKabulButonu);
        }
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        System.out.println("ilkSayfaTitle: "+Driver.getDriver().getTitle());

        jsClick(hepsiburadaPage.aramaKutucugu);
        hepsiburadaPage.aramaKutucugu.sendKeys("roman bin muhtesem gunes");
        jsClick(hepsiburadaPage.araButonu);
       actions.sendKeys(Keys.PAGE_DOWN)
               .perform();
        waitForVisibility(hepsiburadaPage.binMuhtGunesRomaniSayfadakiUrunIsmi,3);
        String binMuhtGunesSayfadakiUrun = hepsiburadaPage.binMuhtGunesRomaniSayfadakiUrunIsmi.getText();
        System.out.println("binMuhtGunesSayfadakiUrun: "+binMuhtGunesSayfadakiUrun);
        jsClick(hepsiburadaPage.secilecekBinMuhtGunesRomani);
        log.info("Kullanici urun listesinden urun secti");

        //  Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        Set<String> allWindows=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWH="";
        for (String each: allWindows) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;}
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println("ikinciSayfaTitle: "+Driver.getDriver().getTitle());

        actions.sendKeys(Keys.ARROW_DOWN)
                .perform();
        jsClick(hepsiburadaPage.digerSaticiButonu);
        waitForVisibility(hepsiburadaPage.digerSaticilar1,3);
        jsClick(hepsiburadaPage.digerSaticilar1);

        waitForVisibility(hepsiburadaPage.urunSepetinizdeEkraniCikis,5);
        jsClick(hepsiburadaPage.urunSepetinizdeEkraniCikis);
        waitForVisibility(hepsiburadaPage.digerSaticilar2,3);
        jsClick(hepsiburadaPage.digerSaticilar2);
        log.info("Secilen urun icin 2 tane farkli saticidan urun secip sepete ekledi");

        //  Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        waitForVisibility(hepsiburadaPage.sepeteGitButonu,5);
        jsClick(hepsiburadaPage.sepeteGitButonu);
        String binMuhtGunesSepettekiUrun = hepsiburadaPage.binMuhtGunesRomaniSepettekiUrunIsmi.getText();
        System.out.println("binMuhtGunesSepettekiUrun: "+hepsiburadaPage.binMuhtGunesRomaniSepettekiUrunIsmi.getText());
        Assert.assertEquals(binMuhtGunesSepettekiUrun, binMuhtGunesSayfadakiUrun);
        log.info("Secilen urunun dogru olarak eklendigi ‘Sepetim’ sayfasinda dogrulandi");
        Driver.closeDriver();
        log.info("Sayfa kapatildi");
    }
}

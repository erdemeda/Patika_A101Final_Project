package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {
    public HepsiBuradaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    public WebElement cerezKabulButonu;
    @FindBy(xpath="//div[@id='myAccount']")
    public WebElement girisYapVeyaUyeOlButonu;
    @FindBy(xpath="//a[@id='login']")
    public WebElement girisYapButonu1;
    @FindBy(xpath="//input[@name='username']")
    public WebElement epostaKutucugu;
    @FindBy(xpath="//button[@id='btnLogin']")
    public WebElement girisYapButonu2;
    @FindBy(xpath="//input[@name='password']")
    public WebElement sifreKutucugu;
    @FindBy(xpath="//button[@id='btnEmailSelect']")
    public WebElement girisYapButonu3;
    @FindBy(xpath="//a[@title='Hesabım']")
    public WebElement girisIslemiDogrulamasi;
    @FindBy(xpath="//input[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    public WebElement aramaKutucugu;
    @FindBy(xpath="//div[text()='ARA']")
    public WebElement araButonu;
    @FindBy(xpath="//a[@class='optionsLength']")
    public WebElement digerSaticiButonu;
    @FindBy(xpath="(//button[@class='add-to-basket button'])[1]")
    public WebElement digerSaticilar1;
    @FindBy(xpath="(//button[@class='add-to-basket button'])[2]")
    public WebElement digerSaticilar2;
    @FindBy(xpath="//button[contains(text(),'Sepete git')]")
    public WebElement sepeteGitButonu;
    @FindBy(xpath="//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement urunSepetinizdeEkraniCikis;
    @FindBy(xpath="//a[@href='/insanlar-matt-haig-p-HBCV00001W0EEH']")
    public WebElement secilecekInsanlarRomani;
    @FindBy(xpath="//h3[text()='İnsanlar - Matt Haig']")
    public WebElement insanlarRomaniSayfadakiUrunIsmi;
    @FindBy(xpath="//a[text()='İnsanlar - Matt Haig']")
    public WebElement insanlarRomaniSepettekiUrunIsmi;
    @FindBy(xpath="//a[@href='/bin-muhtesem-gunes-midi-boy-khaled-hosseini-p-HBV000005HKP9']")
    public WebElement secilecekBinMuhtGunesRomani;
    @FindBy(xpath="//h3[text()='Bin Muhteşem Güneş (Midi Boy) - Khaled Hosseini']")
    public WebElement binMuhtGunesRomaniSayfadakiUrunIsmi;
    @FindBy(xpath="//a[text()='Bin Muhteşem Güneş (Midi Boy) - Khaled Hosseini']")
    public WebElement binMuhtGunesRomaniSepettekiUrunIsmi;

}

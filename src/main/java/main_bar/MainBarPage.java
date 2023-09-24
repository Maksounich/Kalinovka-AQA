package main_bar;

import base.BasePage;
import catalog.CatalogPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainBarPage extends BasePage {

   private SelenideElement logo = $x("//div[@class='site-logo header__l']");
   private SelenideElement catalog = $x("//ul//li[@id='menu-item-31513']");
   private  SelenideElement mens = $x("//ul//li[@id='menu-item-16577']");
   private  SelenideElement womens = $x("//ul//li[@id='menu-item-16576']");
   private  SelenideElement kids = $x("//ul//li[@id='menu-item-27512']");
   private  SelenideElement withPrints = $x("//ul//li[@id='menu-item-27512']");
   private  SelenideElement sets = $x("//ul//li[@id='menu-item-27512']");
   private  SelenideElement demiseason = $x("//ul//li[@id='menu-item-30274']");
   private  SelenideElement sales = $x("//ul//li[@id='menu-item-30489']");
   private SelenideElement searchBtn = $x("//button[contains(@class, 'con-search quick')]");
   private SelenideElement userBtn = $x("//a[@class='site-actions__el icon-user']");
   private SelenideElement wishlistBtn = $x("//a[contains(@class, 'add-to-wishlist-count')]");
   private SelenideElement basketBtn = $x("//a[@class='btn__link_checkout']");
   private SelenideElement searchBar = $x("//input[@type='text']");

   public MainBarPage clickLogo()
   {
      logo.click();
      return this;
   }
   public CatalogPage clickCatalog()
   {
      catalog.click();
      return new CatalogPage();
   }
   public MainBarPage clickMens()
   {
      mens.click();
      return this;
   }
   public MainBarPage clickWomens()
   {
      womens.click();
      return this;
   }
   public MainBarPage clickKids()
   {
      kids.click();
      return this;
   }
   public MainBarPage clickPrints()
   {
      withPrints.click();
      return this;
   }
   public MainBarPage clickDemiSes()
   {
      demiseason.click();
      return this;
   }
   public MainBarPage clickSets()
   {
      sets.click();
      return this;
   }
   public MainBarPage clickSales()
   {
      sales.click();
      return this;
   }
   public MainBarPage clickSearchBtn()
   {
      searchBtn.click();
      return this;
   }
   public MainBarPage clickWishlistBTn()
   {
      wishlistBtn.click();
      return this;
   }
   public MainBarPage clickBasketBtn()
   {
      basketBtn.click();
      return this;
   }
   public MainBarPage clickUserBtn()
   {
      userBtn.click();
      return this;
   }


   public MainBarPage searchSocks(String text)
   {
      searchBar.sendKeys(text, Keys.ENTER);
      return this;
   }

   public MainBarPage subMens(String button)
   {
      SelenideElement subMenuElem = $x("//li[@id=\"menu-item-16577\"]//a[contains(text(),'" + button + "')]");
      mens.hover();
      subMenuElem.click();
      return this;
   }

}

package eBebekTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class eBebekTest {

    private WebDriver driver;

    @Given("Main page opens. \\(www.e-bebek.com)")
    public void main_page_opens_www_e_bebek_com() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.e-bebek.com/");
        driver.manage().window().maximize();
        System.out.println("E-Bebek sitesine gidildi.");
    }
    @And("type biberon in the search bar.")
    public void typeBiberonInTheSearchBar() {
        WebElement searchElement = driver.findElement(By.id("txtSearchBox"));
        searchElement.sendKeys("biberon");
        searchElement.sendKeys(Keys.ENTER);
        System.out.println("Arama çubuğuna biberon yazıldı");
    }

    @And("the search is done.")
    public void the_search_is_done() throws InterruptedException {
        System.out.println("Arama yapıldı.");
        Thread.sleep(3000);
    }

    @And("Click on the first product")
    public void click_on_the_first_product() throws InterruptedException {
        List<WebElement> myElements = driver.findElements(By.className("product-item__brand"));
        myElements.get(0).click();
        System.out.println("İlk ürün seçildi.");
        Thread.sleep(2000);


    }

    @And("Click the Add to Cart button.")
    public void click_the_add_to_cart_button() throws InterruptedException {
        driver.findElement(By.id("addToCartBtn")).click();
        System.out.println("Ürün sepete eklendi.");
        Thread.sleep(2000);

    }

    @And("Click on See Cart button.")
    public void clickOnSeeCartButton() throws InterruptedException {
        driver.findElement(By.id("btnShowCart")).click();
        System.out.println("Sepet görüntülendi.");
        Thread.sleep(2000);

    }

    @And("it is checked that the product has been added to the cart.")
    public void it_is_checked_that_the_product_has_been_added_to_the_cart() {

        WebElement finalText = driver.findElement(By.xpath("//div[@class='d-flex justify-content-between align-items-center basket-product-title ng-star-inserted']"));
        String textElement = finalText.getText();
        String necessaryWord="1";
        if (textElement.contains(necessaryWord)){
            System.out.println("Ürün ekleme başarılı");
        } else {
            System.out.println("Ürün ekleme başarısız.");
        }
    }



}

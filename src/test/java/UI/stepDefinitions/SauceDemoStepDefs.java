package UI.stepDefinitions;
import UI.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauceDemoStepDefs {

    WebDriver driver= Driver.getDriver("chrome");

    Login login=new Login(driver);
    @Given("User on the {string} page")
    public void user_on_the_page(String url) {
        driver.get(url);

    }
    @When("User logs in with username {string} and the password {string}")
    public void user_logs_in_with_username_and_the_password(String userName, String password) {

        login.username.sendKeys(userName);
        login.password.sendKeys(password);
        login.loginButton.click();

    }
    @When("User adds two or more items to the shopping cart")
    public void user_adds_two_or_more_items_to_the_shopping_cart() {

        Select lowPrice=new Select(login.lowestPrice);
        lowPrice.selectByVisibleText("Price (low to high)");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        login.ItemsAddToCard.get(0).click();
       login.ItemsAddToCard.get(1).click();



    }
    @When("User Assert that the items that you added are in the cart")
    public void user_assert_that_the_items_that_you_added_are_in_the_cart() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        login.shopingCardButton.click();
        String firstActualItemInCard="Sauce Labs Onesie";
        String secondActualItemInCard="Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(login.itemsInTheCard.get(0).getText(),firstActualItemInCard);
        Assert.assertEquals(login.itemsInTheCard.get(1).getText(),secondActualItemInCard);

//        for (int i = 0; i < 2; i++) {
//            if (login.itemsInTheCard.get(i).isDisplayed()){
//                System.out.println(login.itemsInTheCard.get(i).getText()+ " : is added to cart");
//            }else{
//                System.out.println("Items are not added to cart");
//            }
//        }
    }
    @Then("User remove an items and then continue shopping")
    public void user_remove_an_items_and_then_continue_shopping() {
        for (int i = 0; i <login.itemsInTheCard.size(); i++) {
            login.removeButton.click();
        }
            login.continueButton.click();
    }
    @Then("User add another items")
    public void user_add_another_items() {
        Select lowPrice=new Select(login.lowestPrice);
        lowPrice.selectByVisibleText("Price (low to high)");

        login.ItemsAddToCard.get(0).click();
        System.out.println(login.ItemsAddToCard.get(0).getText());
        login.shopingCardButton.click();

    }
    @Then("User goes to Checkout")
    public void user_goes_to_checkout() {
        login.checkoutButton.click();

        login.fName.sendKeys("sauce");
        login.lName.sendKeys("demo");
        login.zipCode.sendKeys("80000");
        login.ctnButton.click();
        System.out.println(login.totalPrice.getText());

    }
    @Then("User Validates correct items and the total price")
    public void user_validates_correct_items_and_the_total_price(List<String> expectedResults) {
        String actualPurchasingItem=expectedResults.get(0);
        String actualTotalItem=expectedResults.get(1);
        System.out.println(login.itemAtCheckout.getText());
        Assert.assertEquals(actualPurchasingItem,login.itemAtCheckout.getText());
        Assert.assertEquals(actualTotalItem,login.totalPrice.getText());



    }
    @Then("User Finishes Checkout")
    public void user_finishes_checkout() {
        login.finishButton.click();

    }
}

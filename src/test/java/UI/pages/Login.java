package UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    ////// Login PAGE ////////
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    ////// Home PAGE ///////
    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement lowestPrice;

    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    public List<WebElement> ItemsAddToCard;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    public WebElement shopingCardButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> itemsInTheCard;

    @FindBy(xpath = "//button[@class='btn_secondary cart_button']")
    public WebElement removeButton;

    @FindBy (xpath = "//a[@class='btn_secondary']")
    public WebElement continueButton;

    ////// Checkout PAGE ///////////
    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement fName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    public WebElement ctnButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public WebElement itemAtCheckout;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    public  WebElement totalPrice;

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    public WebElement finishButton;












}

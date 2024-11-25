package bugBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistroPage {

    @FindBy(css = ".login__buttons button[type=\"button\"]")
    public WebElement btnRegistrar;

    @FindBy(css = ".card__register input[type=\"email\"]")
    public WebElement inputEmail;

    @FindBy(css = ".card__register input[name=\"name\"]")
    public WebElement inputName;

    @FindBy(css = ".card__register input[name=\"password\"]")
    public WebElement inputPass;

    @FindBy(css = ".card__register input[name=\"passwordConfirmation\"]")
    public WebElement inputPassConf;

    @FindBy(css = "label[class=\"styles__Input-sc-1pngcbh-1 dTSgXK\"]")
    public WebElement addSaldo;

    @FindBy(css = ".card__register button[type=\"submit\"]")
    public WebElement btnCadastre;

    @FindBy(id = "btnCloseModal")
    public WebElement btnCloseModal;

}

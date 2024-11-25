package bugBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = ".card__login input[type=\"email\"]")
    public WebElement campoEmail;

    @FindBy(css = ".card__login input[name=\"password\"]")
    public WebElement inputPass;

    @FindBy(css = ".login__buttons button[type=\"submit\"]")
    public WebElement btnAcessar;

    @FindBy(id = "btnExit")
    public WebElement btnSair;
}

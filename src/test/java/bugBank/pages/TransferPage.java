package bugBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferPage {

    @FindBy(css = ".card__login input[type=\"email\"]")
    public WebElement campoEmail;

    @FindBy(css = ".card__login input[name=\"password\"]")
    public WebElement inputPass;

    @FindBy(css = ".login__buttons button[type=\"submit\"]")
    public WebElement btnAcessar;

    @FindBy(id = "btn-TRANSFERÊNCIA")
    public WebElement btnTranfer;

    @FindBy(css = "input[type=\"accountNumber\"]")
    public WebElement inputConta;

    @FindBy(css = "input[type=\"digit\"]")
    public WebElement inputDigito;

    @FindBy(css = "input[type=\"transferValue\"]")
    public WebElement valorTransf;

    @FindBy(css = "input[type=\"description\"]")
    public WebElement descTranf;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement btnSubmit;

    @FindBy(id = "btnCloseModal")
    public WebElement btnCloseModal;

    @FindBy(id = "btnExit")
    public WebElement btnSair;

}

package bugBank.tasks;

import bugBank.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import Framework.Utils.FilesOperation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static bugBank.TestBase.driver;

public class LoginTask extends LoginPage {

    public LoginTask(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void LoginPrimeiroUsuario() throws IOException {

        String mail = FilesOperation.getProperties("primeiraConta").getProperty("emailPrimeiraConta");
        String pass = FilesOperation.getProperties("primeiraConta").getProperty("senhaPrimeiraConta");

        campoEmail.sendKeys(mail);
        inputPass.sendKeys(pass);
        btnAcessar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valorElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#textBalance span")));

        // Obtenha o texto do elemento
        String valorTexto = valorElemento.getText();

        // Remover o "R$" e os espaços, se necessário, para trabalhar com o valor numérico
        String saldo = valorTexto.replace("R$", "").replace(" ", "").replace(",", ".");

        FilesOperation.setProperty("primeiraConta", "saldoPrimeiraConta", saldo);

        btnSair.click();
    }

    public void LoginSegundoUsuario() throws IOException {

        String mail = FilesOperation.getProperties("segundaConta").getProperty("emailSegundaConta");
        String pass = FilesOperation.getProperties("segundaConta").getProperty("senhaSegundaConta");

        campoEmail.sendKeys(mail);
        inputPass.sendKeys(pass);
        btnAcessar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valorElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#textBalance span")));

        // Obtenha o texto do elemento
        String valorTexto = valorElemento.getText();

        // Remover o "R$" e os espaços, se necessário, para trabalhar com o valor numérico
        String saldo = valorTexto.replace("R$", "").replace(" ", "").replace(",", ".");

        FilesOperation.setProperty("segundaConta", "saldoSegundaConta", saldo);

        btnSair.click();
    }

}

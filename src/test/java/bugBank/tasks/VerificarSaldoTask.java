package bugBank.tasks;

import Framework.Utils.FilesOperation;
import bugBank.pages.VerificarSaldoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static bugBank.TestBase.driver;

public class VerificarSaldoTask extends VerificarSaldoPage {

    public VerificarSaldoTask(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void verificarsaldoPrimeiroUsuario() throws IOException {
        String nome1 = FilesOperation.getProperties("primeiraConta").getProperty("titularPrimeiraConta");
        String mail1 = FilesOperation.getProperties("primeiraConta").getProperty("emailPrimeiraConta");
        String pass1 = FilesOperation.getProperties("primeiraConta").getProperty("senhaPrimeiraConta");

        campoEmail.sendKeys(mail1);
        inputPass.sendKeys(pass1);
        btnAcessar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valorElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#textBalance span")));

        // Obtenha o texto do elemento
        String valorTexto = valorElemento.getText();

        // Remover o "R$" e os espaços, se necessário, para trabalhar com o valor numérico
        String saldo = valorTexto.replace("R$", "").replace(" ", "").replace(",", ".");

        System.out.println("O saldo atual do usuario1: `" + nome1 + "` é de R$" + saldo);

        btnSair.click();

    }

    public void verificarsaldoSegundoUsuario() throws IOException {
        String nome2 = FilesOperation.getProperties("segundaConta").getProperty("titularSegundaConta");
        String mail2 = FilesOperation.getProperties("segundaConta").getProperty("emailSegundaConta");
        String pass2 = FilesOperation.getProperties("segundaConta").getProperty("senhaSegundaConta");

        campoEmail.sendKeys(mail2);
        inputPass.sendKeys(pass2);
        btnAcessar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valorElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#textBalance span")));

        // Obtenha o texto do elemento
        String valorTexto = valorElemento.getText();

        // Remover o "R$" e os espaços, se necessário, para trabalhar com o valor numérico
        String saldo = valorTexto.replace("R$", "").replace(" ", "").replace(",", ".");

        System.out.println("O saldo atual do usuario2: `" + nome2 + "` é de R$" + saldo);

        btnSair.click();

    }

}

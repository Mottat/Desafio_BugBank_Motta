package bugBank.tasks;

import Framework.Utils.FilesOperation;
import bugBank.pages.TransferPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static bugBank.TestBase.driver;

public class TransferTask extends TransferPage {

    public TransferTask(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void transfer() throws IOException {
        String nome1 = FilesOperation.getProperties("primeiraConta").getProperty("titularPrimeiraConta");
        String mail1 = FilesOperation.getProperties("primeiraConta").getProperty("emailPrimeiraConta");
        String pass1 = FilesOperation.getProperties("primeiraConta").getProperty("senhaPrimeiraConta");
        String valor = FilesOperation.getProperties("primeiraConta").getProperty("valorPrimeiraConta");
        String conta2 = FilesOperation.getProperties("segundaConta").getProperty("numeroSegundaConta");
        String digito2 = FilesOperation.getProperties("segundaConta").getProperty("digitoSegundaconta");

        campoEmail.sendKeys(mail1);
        inputPass.sendKeys(pass1);
        btnAcessar.click();

        btnTranfer.click();

        inputConta.sendKeys(conta2);
        inputDigito.sendKeys(digito2);
        valorTransf.sendKeys(valor);
        descTranf.sendKeys("Transferencia para "+ nome1);

        btnSubmit.click();

        System.out.println("Transferido o valor de R$" + valor +  " para o usuário " + nome1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fecharModal = wait.until(ExpectedConditions.elementToBeClickable(btnCloseModal));
        fecharModal.click();

        btnSair.click();

    }

}

package bugBank.tasks;

import bugBank.pages.RegistroPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Framework.Utils.FilesOperation;
import java.io.IOException;
import java.time.Duration;
import com.github.javafaker.Faker;
import static bugBank.TestBase.driver;

public class RegistroTask extends RegistroPage {

    Faker faker = new Faker(); // Instância do Faker

    public RegistroTask(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public String gerarEmail() {
        return faker.internet().emailAddress();
    }

    public String gerarNome() {
        return faker.name().fullName();
    }

    public String gerarSenha() {
        return "Senha" + faker.number().randomDigitNotZero();
    }

    public int gerarValor() {
        return faker.number().numberBetween(100, 1000);
    }

    public void registrarPrimeiroUsuario() throws IOException {
        String mail = gerarEmail();
        String name = gerarNome();
        String pass = gerarSenha();
        int valor = gerarValor();

        btnRegistrar.click();

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        inputEmail.sendKeys(mail);
        inputName.sendKeys(name);
        inputPass.sendKeys(pass);
        inputPassConf.sendKeys(pass);

        addSaldo.click();

        btnCadastre.click();

        // Aguardar até que o elemento modal esteja visível
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));

        // Capturar o texto completo do modal
        String textoModal = modalText.getText(); // Texto: "A conta xxx-x foi criada com sucesso"

        // Extrair apenas a parte da conta e o dígito usando regex ou split
        String contaCompleta = textoModal.replaceAll("[^0-9-]", ""); // Remove tudo exceto números e o traço
        String[] partesConta = contaCompleta.split("-"); // Divide a conta pelo traço

        // Separar a conta e o dígito
        String conta = partesConta[0]; // "869"
        String digito = partesConta[1]; // "9"

        FilesOperation.setProperty("primeiraConta", "titularPrimeiraConta", name);
        FilesOperation.setProperty("primeiraConta", "emailPrimeiraConta", mail);
        FilesOperation.setProperty("primeiraConta", "senhaPrimeiraConta", pass);
        FilesOperation.setProperty("primeiraConta", "numeroPrimeiraConta", conta);
        FilesOperation.setProperty("primeiraConta", "digitoPrimeiraconta", digito);
        FilesOperation.setProperty("primeiraConta", "valorPrimeiraConta", String.valueOf(valor));

        // Clicar botão Fechar
        WebElement fecharModal = wait.until(ExpectedConditions.elementToBeClickable(btnCloseModal));
        fecharModal.click();

        // Verificar botão Acessar
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login__buttons button[type=\"submit\"]")));
        Assertions.assertTrue(submit.isDisplayed());

    }

   public void registrarSegundoUsuario() throws IOException {
       String mail = gerarEmail();
       String name = gerarNome();
       String pass = gerarSenha();

        btnRegistrar.click();

       // Scroll down
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        inputEmail.clear();
        inputEmail.sendKeys(mail);
        inputName.clear();
        inputName.sendKeys(name);
        inputPass.clear();
        inputPass.sendKeys(pass);
        inputPassConf.clear();
        inputPassConf.sendKeys(pass);
        addSaldo.click();
        btnCadastre.click();

        // Aguardar até que o elemento modal esteja visível
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));

        // Capturar o texto completo do modal
        String textoModal = modalText.getText(); // Texto: "A conta xxx-x foi criada com sucesso"

        // Extrair apenas a parte da conta e o dígito usando regex ou split
        String contaCompleta = textoModal.replaceAll("[^0-9-]", ""); // Remove tudo exceto números e o traço
        String[] partesConta = contaCompleta.split("-"); // Divide a conta pelo traço

        // Separar a conta e o dígito
        String conta = partesConta[0]; // "869"
        String digito = partesConta[1]; // "9"

        FilesOperation.setProperty("segundaConta", "titularSegundaConta", name);
       FilesOperation.setProperty("segundaConta", "emailSegundaConta", mail);
       FilesOperation.setProperty("segundaConta", "senhaSegundaConta", pass);
        FilesOperation.setProperty("segundaConta", "numeroSegundaConta", conta);
        FilesOperation.setProperty("segundaConta", "digitoSegundaconta", digito);
//        FilesOperation.setProperty("segundaConta", "saldoSegundaConta", saldo);

       // Clicar botão Fechar
       WebElement fecharModal = wait.until(ExpectedConditions.elementToBeClickable(btnCloseModal));
       fecharModal.click();

       // Verificar botão Acessar
       WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login__buttons button[type=\"submit\"]")));
       Assertions.assertTrue(submit.isDisplayed());

   }


}

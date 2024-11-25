package bugBank.testCases;

import bugBank.TestBase;
import bugBank.tasks.LoginTask;
import bugBank.tasks.RegistroTask;
import bugBank.tasks.TransferTask;
import bugBank.tasks.VerificarSaldoTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

class BugBankTest extends TestBase {

    private final WebDriver driver = getDriver();

    RegistroTask registroTask = new RegistroTask(driver);
    LoginTask loginTask = new LoginTask(driver);
    TransferTask transferTask = new TransferTask(driver);
    VerificarSaldoTask verificarSaldoTask = new VerificarSaldoTask(driver);

    @Test
    public void BugBank() throws IOException {
        registroTask.registrarPrimeiroUsuario();
        loginTask.LoginPrimeiroUsuario();

        registroTask.registrarSegundoUsuario();
        loginTask.LoginSegundoUsuario();

        transferTask.transfer();

        verificarSaldoTask.verificarsaldoPrimeiroUsuario();
        verificarSaldoTask.verificarsaldoSegundoUsuario();
    }
}

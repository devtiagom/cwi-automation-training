package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.assertTrue;

public class SetupTest extends BaseTests {

    @Test
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    public void testLogin() {
        // Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickBtnLogin();
        System.out.println("Clicou em Sign In e direcionou para página de login");
        assertTrue(Browser.getCurrentDriver()
                .getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        login.fillEmail();
        System.out.println("Preencheu o e-mail");
        login.fillPasswd();
        System.out.println("Preencheu a senha");
        login.clickBtnSubmitLogin();
        System.out.println("Clicou em Sign In");
        assertTrue(Browser
                .getCurrentDriver()
                .getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a url de minha conta");
        assertTrue(Browser
                .getCurrentDriver()
                .findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou minha conta no site");



//        Browser.getCurrentDriver().findElement(By.className("login")).click();
//        System.out.println("Clicou em Sign In e direcionou para página de login");
//        assertTrue(Browser.getCurrentDriver()
//                .getCurrentUrl()
//                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
//        Browser.getCurrentDriver()
//                .findElement(By.id("email"))
//                .sendKeys("tiago.o.machado@gmail.com");
//        System.out.println("Preencheu o e-mail");
//        Browser.getCurrentDriver()
//                .findElement(By.id("passwd"))
//                .sendKeys("12345");
//        System.out.println("Preencheu a senha");
//        Browser.getCurrentDriver()
//                .findElement(By.id("SubmitLogin"))
//                .click();
//        System.out.println("Clicou em Sign In");
//        assertTrue(Browser
//                .getCurrentDriver()
//                .getCurrentUrl()
//                .contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
//        System.out.println("Validou a url de minha conta");
//        assertTrue(Browser
//                .getCurrentDriver()
//                .findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
//        System.out.println("Validou minha conta no site");
    }
}

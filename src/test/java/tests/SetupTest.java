package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

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
    }

    @Test
    public void testSearch() {
        String quest = "DRESS";
        String questResultQtd = "7";

        // Iniciar páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        // Fazer a pesquisa
        home.doSearch(quest);

        // Validar a pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""), quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
    }

    @Test
    public void testAccessCategoryTShirts() {
        // Iniciar páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        // Clicar na categoria T-SHIRTS
        home.clickCategoryTShirts();

        // Validar se ao clicar na categotia T-SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTshirts());
    }

    @Test
    public void testAddProductToProductPage() {
        // Acessar a categoria T-SHIRTS
        testAccessCategoryTShirts();

        // Iniciar páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        // Obter nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        // Clicar em More e direcionar para a página do produto
        category.clickProductAddToProductPage();

        // Verificar se o produto está na página de detalhes do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));
    }

    @Test
    public void testAddProductToCartPage() {
        // Acessar a página de produto
        testAddProductToProductPage();

        // Iniciar páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        // Obter nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();

        // Clicar no botão de adicionar ao carrinho
        pdp.clickButtonAddToCart();

        // Clicar no botão Proceed to Checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        // Validar o nome do produto no carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));
    }
}

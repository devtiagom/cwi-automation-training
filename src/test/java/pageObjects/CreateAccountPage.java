package pageObjects;

import elementMapper.CreateAccountPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CreateAccountPage extends CreateAccountPageElementMapper {

    public CreateAccountPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void checkMaleGender() {
        maleGender.click();
    }

    public void fillFirstName(String userFirstName) {
        firstName.sendKeys(userFirstName);
    }

    public void fillLastName(String userLastName) {
        lastName.sendKeys(userLastName);
    }

    public void fillPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    public void fillAddress(String userAddress) {
        address.sendKeys(userAddress);
    }

    public void fillCity(String userCity) {
        city.sendKeys(userCity);
    }

    public void fillState(String userState) {
        state.sendKeys(userState);
    }

    public void fillZipcode(String userZipcode) {
        zipcode.sendKeys(userZipcode);
    }

    public void fillPhone(String userPhone) {
        phone.sendKeys(userPhone);
    }

    public void fillAddressAlias(String userAddressAlias) {
        addressAlias.clear();
        addressAlias.sendKeys(userAddressAlias);
    }

    public void fillAll() {
        fillFirstName("Fulano");
        fillLastName("de Tal");
        fillPassword("12345");
        fillAddress("Rua Desconhecida, 123");
        fillCity("Los Angeles");
        fillState("California");
        fillZipcode("11111");
        fillPhone("51999999999");
        fillAddressAlias("Minha Casa");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}

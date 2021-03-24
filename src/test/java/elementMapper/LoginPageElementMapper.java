package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    public WebElement email;

    public WebElement passwd;

    public WebElement SubmitLogin;

    @FindBy(id = "email_create")
    public WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    public WebElement submitCreate;
}

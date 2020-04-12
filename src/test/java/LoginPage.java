import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //TODO: rework with this pattern
//    @FindBy(id = "username")
//    WebElement usernameInput;
//
//    @FindBy(id = "password")
//    WebElement passwordInput;

    private String loginNameCorrect = "root";
    private String passwordCorrect = "toorP@ssw0rd";

    public void loginCorrect() {
        login(loginNameCorrect, passwordCorrect);
    }

    private void login(String name, String password) {
        $(By.id("username")).val(name);
        $(By.id("password")).val(password).pressEnter();
    }

    //TODO: rework with this pattern
//
//    private void login(String name, String password) {
//        $(usernameInput).val(name);
//        $(passwordInput).val(password).pressEnter();
//    }
}

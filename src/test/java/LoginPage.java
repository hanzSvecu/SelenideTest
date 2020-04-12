import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameInput = $(byId("username"));
    private SelenideElement passwordInput = $(byId("password"));
    private String loginNameCorrect = "root";
    private String passwordCorrect = "toorP@ssw0rd";

    public void loginCorrect() {
        login(loginNameCorrect, passwordCorrect);
    }

    private void login(String name, String password) {
        usernameInput.val(name);
        passwordInput.val(password).pressEnter();
    }
}

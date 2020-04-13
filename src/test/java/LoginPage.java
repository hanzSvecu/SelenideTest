import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

class LoginPage {

    private SelenideElement usernameInput = $(byId("username"));
    private SelenideElement passwordInput = $(byId("password"));

    // not a good practice, should be in external file
    private String loginNameCorrect = "root";
    private String passwordCorrect = "toorP@ssw0rd";

    void loginCorrect() {
        login(loginNameCorrect, passwordCorrect);
    }

    private void login(String name, String password) {
        usernameInput.val(name);
        passwordInput.val(password).pressEnter();
    }
}

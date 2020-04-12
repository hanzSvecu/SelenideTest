import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyDashboardPage {

    private SelenideElement createNewIssue = $(byXpath("//*[@id=\"headerContainer\"]/div/div[1]/div/div/div/div/div/button"));

    // TODO: add proper check
    public boolean checkThatNewIssueIsPresent(String issueName){
        return false;
    }

    public void createNewIssue() {
        createNewIssue.click();
    }

}

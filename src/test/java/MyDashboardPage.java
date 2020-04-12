import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyDashboardPage {

    private String createNewIssueXpath = "//*[@id=\"headerContainer\"]/div/div[1]/div/div/div/div/div/button";

    // TODO: add proper check
    public boolean checkThatNewIssueIsPresent(String issueName){
        return false;
    }

    public void createNewIssue() {
        $(By.xpath(createNewIssueXpath)).click();
    }

}

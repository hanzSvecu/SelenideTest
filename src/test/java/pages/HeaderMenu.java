package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu {

    private SelenideElement issuesButton = $(byCssSelector("a[ng-href='issues']"));
    private SelenideElement dashboardsButton = $(byCssSelector("a[data-test-id='Dashboard']"));
    private SelenideElement agileBoardsButton = $(byCssSelector("a[data-test-id='Agile Boards']"));
    private SelenideElement reportsButton = $(byCssSelector("a[data-test-id='Reports']"));
    private SelenideElement projectsButton = $(byCssSelector("a[data-test-id='Projects']"));
    private SelenideElement newIssueButton = $(byCssSelector("button[data-test='createIssueButton']"));

    public void goToIssues(){
        issuesButton.shouldBe(Condition.visible).click();
    }

    public void createNewIssue() {
        newIssueButton.shouldBe(Condition.visible).click();
    }

}


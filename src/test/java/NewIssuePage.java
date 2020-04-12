import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewIssuePage {

    private String newIssueButtonClass = "content_588";
    private String createButtonClass = "ring-input yt-vgutter-bottom-2 yt-autoresize-field yt-fix-ring-min-height yt-issue-body__summary-common yt-issue-body__summary__input ng-valid ng-touched ng-dirty ng-valid-parse ng-not-empty";
    private String createButtonXpath = "/html/body/div[1]/div/div/div/yt-analytics-zone/div/yt-issue-layout/div/div[1]/div/yt-issue-layout-body/yt-panel/ng-transclude/button[1]";
    private String summaryXpath = "/html/body/div[1]/div/div/div/yt-analytics-zone/div/yt-issue-layout/div/div[1]/div/yt-issue-layout-body/yt-dropzone/div/ng-transclude/textarea[1]";
    private String issueListClass = "ring-menu__item__i";

    private SelenideElement createButton = $(byXpath(createButtonXpath));
    private SelenideElement summaryInput = $(byXpath(summaryXpath));

    //TODO: generalize to page class
    private ElementsCollection headerOptions = $$(byClassName(issueListClass));

    // mandatory to create issue in app
    public void insertSummary(String summary) {
        summaryInput.val(summary);
    }

    public void createIssue() {
        createButton.shouldBe(Condition.visible).click();
    }

    //TODO: generalize to page class
    public void goToIssues(){
        for (SelenideElement option: headerOptions){
            if (option.getText().contains("Issues")) {
                option.shouldBe(Condition.visible).click();
            }
            break;
        }
    }

}

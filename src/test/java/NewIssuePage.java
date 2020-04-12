import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewIssuePage {

    private String newIssueButtonClass = "content_588";
    private String createButtonClass = "ring-input yt-vgutter-bottom-2 yt-autoresize-field yt-fix-ring-min-height yt-issue-body__summary-common yt-issue-body__summary__input ng-valid ng-touched ng-dirty ng-valid-parse ng-not-empty";
    private String createButtonXpath = "/html/body/div[1]/div/div/div/yt-analytics-zone/div/yt-issue-layout/div/div[1]/div/yt-issue-layout-body/yt-panel/ng-transclude/button[1]";
    private String summaryXpath = "/html/body/div[1]/div/div/div/yt-analytics-zone/div/yt-issue-layout/div/div[1]/div/yt-issue-layout-body/yt-dropzone/div/ng-transclude/textarea[1]";
    private String issueListClass = "ring-menu__item__i";

    // mandatory
    public void insertSummary(String summary) {
        $(By.xpath(summaryXpath)).val(summary);
    }

    public void createIssue() {
//        $(By.className(createButtonClass)).click();
        $(By.xpath(createButtonXpath)).shouldBe(Condition.visible).click();
    }

    //TODO: generalize to page class
    public void goToIssues(){
        ElementsCollection elements = $$(By.className(issueListClass));
        for (SelenideElement element: elements){
            if (element.getText().contains("Issues")) {
              element.shouldBe(Condition.visible).click();
            }
            break;
        }
    }



}

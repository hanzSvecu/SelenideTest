package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class NewIssuePage {

    private SelenideElement createButton = $(byCssSelector("button[data-test='createIssueAction']"));
    private SelenideElement summaryInput = $(byCssSelector("textarea[data-test='issueSummary']"));

    // mandatory to create issue in app
    public void insertSummary(String summary) {
        summaryInput.val(summary);
    }

    public void createIssue() {
        createButton.shouldBe(Condition.visible).click();
    }

}

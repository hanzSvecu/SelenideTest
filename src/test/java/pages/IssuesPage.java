package pages;

import com.codeborne.selenide.*;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IssuesPage extends TemplatePage {

    private ElementsCollection allItemsInIssue = $$(byCssSelector("yt-issue-summary[class='yt-issue-summary']"));

    private SelenideElement issuesSidebar = $(byCssSelector("div[data-test='issuesSidebar']"));
    private SelenideElement issuesQuery = $(byCssSelector("div[data-test='ring-query-assist']"));

    @Override
    public void isOpen(){
        issuesSidebar.shouldBe(Condition.visible);
        issuesQuery.shouldBe(Condition.visible);
    }

    public void isNewIssueListed(String issueName) {
        Selenide.refresh();
        // needed for synchronization; there should be at least the 1 that was created
        allItemsInIssue.shouldBe(CollectionCondition.sizeGreaterThan(0));
        boolean isInList = false;
        for (SelenideElement es: allItemsInIssue){
            if (es.getText().equals(issueName)){
                isInList = true;
                break;
            }
        }
        Assert.assertTrue(isInList);
    }

}

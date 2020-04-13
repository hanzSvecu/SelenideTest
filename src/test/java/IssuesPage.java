import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$$;

class IssuesPage {

    private ElementsCollection allItemsInIssue = $$(byCssSelector("yt-issue-summary[class='yt-issue-summary']"));

    void isNewIssueListed(String issueName) {
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

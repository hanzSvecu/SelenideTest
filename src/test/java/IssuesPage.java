import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors.ByText;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class IssuesPage {

//    private String allItemsInIssueListClass = "yt-issues-tree__node yt-hover-actions yt-gutter-left-0 yt-issues-tree__node_compact";
    private String allItemsInIssueListXpath = "/html/body/div[1]/div/div/div/yt-analytics-zone/yt-navigation-zone/yt-navigation/div[3]/div/div[2]/div[2]/div/yt-events-animator/yt-sortable-tree/div/yt-sortable-tree-node";

    private ElementsCollection allItemsInIssue = $$(byXpath(allItemsInIssueListXpath));

    public void isNewIssueListed(String issueName) {
        Selenide.refresh();
        // needed for synchronization; there should be at least the 1 that was created
        allItemsInIssue.shouldBe(CollectionCondition.sizeGreaterThan(0));
        boolean isInList = false;
        for (SelenideElement es: allItemsInIssue){
            if (es.find(new ByText(issueName)).exists()) {
                isInList = true;
                break;
            }
        }
        Assert.assertTrue(isInList);
    }

}

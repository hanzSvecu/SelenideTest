import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors.ByText;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IssuesPage {

//    private String allItemsInIssueListClass = "yt-issues-tree__node yt-hover-actions yt-gutter-left-0 yt-issues-tree__node_compact";
    private String allItemsInIssueListXpath = "/html/body/div[1]/div/div/div/yt-analytics-zone/yt-navigation-zone/yt-navigation/div[3]/div/div[2]/div[2]/div/yt-events-animator/yt-sortable-tree/div/yt-sortable-tree-node";

    private SelenideElement allItemsInIssueList = $(byXpath(allItemsInIssueListXpath));
    private ElementsCollection allItemsInIssue = $$(byXpath(allItemsInIssueListXpath));

    public void isNewIssueListed(String issueName) {
        Selenide.refresh();
        // needed fo synchronization - cannot be done with collection
        allItemsInIssueList.shouldBe(Condition.visible);
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

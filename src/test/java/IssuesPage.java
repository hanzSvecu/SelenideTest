import com.codeborne.selenide.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.Selectors.ByText;

public class IssuesPage {

    private String issueListClass = "yt-issues-tree ng-pristine ng-untouched ng-valid ng-not-empty";
    private String allItemsInIssueListClass = "yt-issues-tree__node yt-hover-actions yt-gutter-left-0 yt-issues-tree__node_compact";
    private String allItemsInIssueListXpath = "/html/body/div[1]/div/div/div/yt-analytics-zone/yt-navigation-zone/yt-navigation/div[3]/div/div[2]/div[2]/div/yt-events-animator/yt-sortable-tree/div/yt-sortable-tree-node";

    public void isNewIssueListed(String issueName) {
        Selenide.refresh();
        $(By.xpath(allItemsInIssueListXpath)).shouldBe(Condition.visible);
        ElementsCollection ses =  $$(By.xpath(allItemsInIssueListXpath));
        boolean isInList = false;
        for (SelenideElement es: ses){
            if (es.find(new ByText(issueName)).exists()) {
                isInList = true;
                break;
            }
        }
        Assert.assertTrue(isInList);
    }

}

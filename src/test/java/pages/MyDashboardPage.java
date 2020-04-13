package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class MyDashboardPage {

    private SelenideElement allItemsInIssue = $(byCssSelector("span[data-test='dashboards-dropdown']"));

    public void isOpen(){
        allItemsInIssue.shouldBe(Condition.visible);
    }
}

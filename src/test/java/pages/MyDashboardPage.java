package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class MyDashboardPage extends TemplatePage{

    private SelenideElement dashboardPageTitle = $(byCssSelector("span[data-test='dashboards-dropdown']"));

    @Override
    public void isOpen(){
        Selenide.refresh();
        dashboardPageTitle.shouldBe(Condition.visible);
    }

    public void createNewIssue(){
        header.createNewIssue();
    }
}

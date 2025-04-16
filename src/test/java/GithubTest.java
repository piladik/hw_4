
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTest {

    @BeforeEach
    void setUp() {
        baseUrl = "https://github.com";
        browserSize = "1920x1080";
    }

    @Test
    void checkJUnitExampleCodeExist() {
        open(baseUrl + "/selenide/selenide");
        $("nav.js-repo-nav").find(byText("Wiki")).click();
        $(withTagAndText("a", "Soft assertions")).click();

        $(withTagAndText("h4", "JUnit5 extend test class"))
                .parent()
                .sibling(0)
                .$("pre")
                .shouldHave(text(
                        "@ExtendWith({SoftAssertsExtension.class}) class Tests {\n" +
                                "  @Test\n" +
                                "  void test() {\n" +
                                "    Configuration.assertionMode = SOFT;\n" +
                                "    open(\"page.html\");\n" +
                                "    $(\"#first\").should(visible).click();\n" +
                                "    $(\"#second\").should(visible).click();\n" +
                                "  }\n" +
                                "}"
                ));
    }
}

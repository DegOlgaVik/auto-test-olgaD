
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

@Owner("Olga")
public class MainTest {

    @Test
    @Story("Добавление в корзину")
    @DisplayName("Добавление товара в корзину через быструю корзину")
    public void setup() {
        // Открыть страницу http://automationpractice.com/index.php
        open("http://automationpractice.com/index.php");
        // Проверить переход на главную страницу
        TestPages.mainPage.mainSliderBlock()
                .shouldBe(visible);
        // Навести курсором на первую карточку товара
        TestPages.mainPage.cardProductBlock().first()
                .hover();
        // Кликнуть на первую кнопку "Добавить в корзину"
        TestPages.mainPage.addToCartButton().first()
                .click();
        // Проверить переход на модалку добавления в корзину
        TestPages.mainPage.modalButton()
                .shouldBe(visible);
    }
}

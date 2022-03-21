package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public SelenideElement mainSliderBlock() {
        return $("[id='slider_row']").as("Слайдер");
    }
    public ElementsCollection cardProductBlock() {
            return $$(".product-container");
    }
    public ElementsCollection addToCartButton() {
        return $$(".ajax_add_to_cart_button");
    }
    public SelenideElement modalButton() {
        return $(".button-container [href='http://automationpractice.com/index.php?controller=order']").as("Кнопка перехода в чекаут");
    }
}
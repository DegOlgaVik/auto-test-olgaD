package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public SelenideElement mainSignInButton() {
        return $(".login").as("Кнопка авторизации");
    }
    public SelenideElement emailAddressInput() {
            return $("[id='email']").as("Введите логин");
    }
    public SelenideElement passwordInput() {
            return $("[id='passwd']").as("пароль");
    }
    public SelenideElement submitLoginButton() {
            return $("[id='SubmitLogin']").as("кнопка Входа");
    }
    public SelenideElement myAccountButton() {
        return $(".home").as("MY ACCOUNT");
    }
    public SelenideElement navigationPageButton() {
        return $(".navigation_page").as("Кнопка навигации");
    }
    public SelenideElement personalInformationButton() {
        return $(".icon-user").as("Персональная информация");
    }
    public SelenideElement oldPasswordInput() {
        return $("[id='old_passwd']").as("текущий пароль");
    }
    public SelenideElement newPasswordInput() {
        return $("[id='passwd']").as("текущий пароль");
    }
    public SelenideElement controlNewPasswordInput() {
        return $("[id='confirmation']").as("подтверждение нового пароля");
    }
    public SelenideElement  submitButton() {
        return $(".form-group .icon-chevron-right").as("кнопка сохранить");
    }
    public SelenideElement incorrectInfo() {
        return $(".alert").as("Информация с ошибкой");
    }
}
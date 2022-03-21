import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("Olga")
public class PasswordTest {

    @BeforeAll
    public static void setup() {
        // Открыть страницу http://automationpractice.com/index.php
                 open("http://automationpractice.com/index.php");
        // Проверить переход на главную страницу
        TestPages.profilePage.mainSignInButton()
                .shouldBe(visible);
        // Кликнуть на кнопку "Авторизоваться"
        TestPages.profilePage.mainSignInButton()
                .click();
        // Ввесть емейл
        TestPages.profilePage.emailAddressInput()
                .sendKeys("ov.degteva@gmail.com");
        // Ввесть пароль
        TestPages.profilePage.passwordInput()
                .sendKeys("11111111");
        // Авторизоваться с введенными данными
        TestPages.profilePage.submitLoginButton()
                .click();
        // Проверить переход на страницу с личной информацией
        TestPages.profilePage.myAccountButton()
                .shouldBe(visible);
        // Кликнуть на кнопку "My personal information"
        TestPages.profilePage.personalInformationButton()
                .click();
        // Проверить переход на страницу с навигацией
        TestPages.profilePage.navigationPageButton()
                .shouldBe(visible);
        // Ввести текущий пароль
        TestPages.profilePage.oldPasswordInput()
                .sendKeys("11111111");
    }
    @Story("Смена пароля")
    @MethodSource("incorrectCredentials")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Негативные кейсы для смены пароля в разделе личных данных:")
    public void negativeSearchChecksTest(String type, String newpassword, String controlpassword){
        // Ввести новый пароль
        TestPages.profilePage.newPasswordInput()
                .sendKeys(newpassword);
        // Ввести подтверждение нового пароля
        TestPages.profilePage.controlNewPasswordInput()
                .sendKeys(controlpassword);
        // Кликнуть по кнопке "Сохранить"
        TestPages.profilePage.submitButton()
                .click();
        // Проверить информацию об ошибке
        TestPages.profilePage.incorrectInfo()
                .shouldBe(visible);
    }

    static Stream<Arguments> incorrectCredentials() {
        return Stream.of(
                arguments(
                        "изначальный пароль без подтверждения пароля",
                        "11111111",
                        " "
                ),
                arguments(
                        "новый пароль с подтверждения старого пароля",
                        "22222222",
                        "11111111"
                ),
                arguments(
                        "пустой новый пароль с подтверждения старого пароля",
                        " ",
                        "11111111"
                ),
                arguments(
                        "пустой новый пароль с пустым подтверждением",
                        " ",
                        " "
                ),
                arguments(
                        "новый пароль и неверное подтверждение нового пароля",
                        "22222222",
                        "33333333"
                )
        );
    }
}


package ru.job4j.early;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.early.PasswordValidator.*;

class PasswordValidatorTest {

    @Test
    public void whenPasswordNotSet() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> validate(null));
        assertThat(thrown.getMessage()).isEqualTo("Password not set.");
    }

    @Test
    public void whenPasswordIsGood() {
        assertThat(validate("a1B&cD_5")).isEqualTo("Good password.");
    }

    @Test
    public void whenPasswordIsBad() {
        assertThat(validate("As&qwerty666"))
                .isEqualTo("Password must not contain 'qwerty', '12345', 'password', 'admin', 'user'.");
    }

    @Test
    public void whenStringLengthIsLessThan8() {
        assertThat(validate("Ab1%"))
                .isEqualTo("Password length must be at least 8 and not more than 32 characters.");
    }

    @Test
    public void whenStringLengthIsGreaterThan32() {
        assertThat(validate(
                "Ab1%aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
                .isEqualTo("Password length must be at least 8 and not more than 32 characters.");
    }

    @Test
    public void whenNoDigits() {
        assertThat(validate("aBcD%^&*"))
                .isEqualTo("Password must contain at least one digit.");
    }

    @Test
    public void whenNoLowerCaseLetters() {
        assertThat(validate("ABCD123&"))
                .isEqualTo("Password must contain at least one lowercase letter.");
    }

    @Test
    public void whenNoUpperCaseLetters() {
        assertThat(validate("abcd123&"))
                .isEqualTo("Password must contain at least one uppercase letter.");
    }

    @Test
    public void whenNoSpecialCharacters() {
        assertThat(validate("AbCd1234"))
                .isEqualTo("Password must contain at least one special character.");
    }
}
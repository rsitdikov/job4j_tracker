package ru.job4j.early;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.early.PasswordValidator.*;

class PasswordValidatorTest {

    @Test
    public void whenPasswordNotSet() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate(null));
        assertThat(thrown.getMessage()).isEqualTo("Password not set.");
    }

    @Test
    public void whenPasswordIsGood() {
        assertThat(validate("a1B&cD_5")).isEqualTo("Good password.");
    }

    @Test
    public void whenPasswordIsBad() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate("As&qwerty666"));
        assertThat(thrown.getMessage())
                .isEqualTo(
                        "Password must not contain 'qwerty', '12345', "
                                + "'password', 'admin', 'user'.");
    }

    @Test
    public void whenStringLengthIsLessThan8() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate("Ab1%"));
        assertThat(thrown.getMessage())
                .isEqualTo("Password length must be at"
                        + " least 8 and not more than 32 characters.");
    }

    @Test
    public void whenStringLengthIsGreaterThan32() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate(
                "Ab1%aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertThat(thrown.getMessage())
                .isEqualTo("Password length must be at least 8 and not "
                        + "more than 32 characters.");
    }

    @Test
    public void whenNoDigits() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate("aBcD%^&*"));
        assertThat(thrown.getMessage())
                .isEqualTo("Password must contain at least one digit.");
    }

    @Test
    public void whenNoLowerCaseLetters() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate("ABCD123&"));
        assertThat(thrown.getMessage()).isEqualTo("Password must "
                + "contain at least one lowercase letter.");
    }

    @Test
    public void whenNoUpperCaseLetters() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate("abcd123&"));
        assertThat(thrown.getMessage()).isEqualTo("Password must contain"
                + " at least one uppercase letter.");
    }

    @Test
    public void whenNoSpecialCharacters() {
        Throwable thrown = assertThrows(IllegalArgumentException.class,
                () -> validate("AbCd1234"));
        assertThat(thrown.getMessage()).isEqualTo("Password must contain"
                + " at least one special character.");
    }
}
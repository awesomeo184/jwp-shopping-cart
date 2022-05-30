package woowacourse.shoppingcart.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomerTest {

    @DisplayName("이메일 형식이 맞지 않는 경우 예외가 발생한다.")
    @Test
    void throwsExceptionWhenInvalidEmailFormat() {
        // given
        String email = "beomWhale";
        String nickname = "범고래";
        String password = "Password12345!";

        // when && then
        assertThatThrownBy(() -> new Customer(email, nickname, password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이메일 형식이 맞지 않습니다.");
    }

    @DisplayName("패스워드 형식이 맞지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"password123!", "PASSWORD123!", "Password123", "Password!@#", "Aa1!123",
            "Password123412341234!"})
    void throwsExceptionWhenInvalidPasswordFormat(String password) {
        // given
        String email = "beomWhale@gmail.com";
        String nickname = "범고래";

        // when && then
        assertThatThrownBy(() -> new Customer(email, nickname, password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("패스워드 형식이 맞지 않습니다.");
    }
}

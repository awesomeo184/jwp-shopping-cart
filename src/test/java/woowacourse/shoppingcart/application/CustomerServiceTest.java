package woowacourse.shoppingcart.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import woowacourse.shoppingcart.dao.CustomerDao;
import woowacourse.shoppingcart.domain.Customer;
import woowacourse.shoppingcart.dto.CustomerCreateRequest;

@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CustomerService customerService;
    private CustomerDao customerDao;

    @BeforeEach
    void setUp() {
        customerDao = new CustomerDao(jdbcTemplate);
        customerService = new CustomerService(customerDao);
    }

    @DisplayName("유저 생성 정보를 입력 받아, 회원가입을 한다.")
    @Test
    void createCustomer() {
        // given
        CustomerCreateRequest customerCreateRequest = new CustomerCreateRequest(
            "beomWhale@naver.com", "범고래", "Password12345!");

        // when
        Long savedId = customerService.createCustomer(customerCreateRequest);

        // then
        assertThat(savedId).isNotNull();
    }

    @DisplayName("닉네임이 중복될 경우, 예외가 발생한다.")
    @Test
    void validateDuplicationNickname() {
        // given
        customerDao.save(new Customer("awesomeo@naver.com", "범고래", "Password12345!"));
        CustomerCreateRequest customerCreateRequest = new CustomerCreateRequest(
            "beomWhale@naver.com", "범고래", "Password12345!");

        // when && then
        assertThatThrownBy(
            () -> customerService.createCustomer(customerCreateRequest)).isInstanceOf(
                IllegalArgumentException.class)
            .hasMessage("이미 존재하는 닉네임입니다.");
    }
}
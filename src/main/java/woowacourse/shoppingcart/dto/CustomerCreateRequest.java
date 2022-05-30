package woowacourse.shoppingcart.dto;

import woowacourse.shoppingcart.domain.Customer;

public class CustomerCreateRequest {
    private final String email;
    private final String nickname;
    private final String password;

    public CustomerCreateRequest(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public Customer toCustomer() {
        return new Customer(email, nickname, password);
    }
}

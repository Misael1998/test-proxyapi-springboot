package dev.fakestore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private String email;
    private String username;
    private String password;
    private UserNames name;
    private UserAddress address;
    private String phone;

}

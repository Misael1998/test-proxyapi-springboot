package dev.fakestore.domain.response;

import dev.fakestore.domain.dto.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends UserDetails {
    private Integer id;
}

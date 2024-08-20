package dev.fakestore.domain.response;

import dev.fakestore.domain.dto.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse extends Cart {
    private String id;
}

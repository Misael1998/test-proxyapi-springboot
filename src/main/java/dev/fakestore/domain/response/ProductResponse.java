package dev.fakestore.domain.response;

import dev.fakestore.domain.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends Product {
    private Integer id;
}

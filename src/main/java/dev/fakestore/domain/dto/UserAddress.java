package dev.fakestore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    private String city;
    private String street;
    private Integer number;
    private String zipcode;
    private GeoLocation geolocation;
}

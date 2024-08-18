package dev.fakestore.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User DTO
 * This DTO contains the required User information for its authentication
 *
 * @author Misael Landero
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * Username
     */
    @Schema(
            description = "Username",
            type = "String",
            example = "johnd"
    )
    private String username;
    /**
     * Password
     */
    @Schema(
            description = "Password",
            type = "String",
            example = "m38rmF$"
    )
    private String password;
}

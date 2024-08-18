package dev.fakestore.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Authorization Token
 * This DTO contains the token obtained by the authentication method
 *
 * @author Misael Landero
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {
    /**
     * JWT
     */
    @Schema(
            description = "JWT",
            type = "String",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsInVzZXIiOiJqb2huZCIsImlhdCI6MTcyNDAwNjcyOX0.UuDvsLX4ltF2h7Q8NUyaa2qOt-zrTTPJShVJk6CmxPQ"
    )
    private String token;
}

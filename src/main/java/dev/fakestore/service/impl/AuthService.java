package dev.fakestore.service.impl;

import dev.fakestore.service.IAuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.stereotype.Service;

@Service
@SecurityRequirement(name = "javainuseapi")
public class AuthService  implements IAuthService {
    @Override
    public String auth(String user) {
        return null;
    }
}

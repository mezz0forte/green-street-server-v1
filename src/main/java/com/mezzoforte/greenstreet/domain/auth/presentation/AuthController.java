package com.mezzoforte.greenstreet.domain.auth.presentation;

import com.mezzoforte.greenstreet.domain.auth.presentation.dto.request.JoinRequest;
import com.mezzoforte.greenstreet.domain.auth.presentation.dto.request.LoginRequest;
import com.mezzoforte.greenstreet.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public void join(@RequestBody JoinRequest request) {

    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody LoginRequest request) {
        authService.login(request);
    }
}

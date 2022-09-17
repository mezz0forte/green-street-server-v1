package com.mezzoforte.greenstreet.domain.user.presentation;

import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.domain.user.service.UserService;
import com.mezzoforte.greenstreet.global.annotation.AuthorizationCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @AuthorizationCheck
    @DeleteMapping
    public void unregister(@RequestAttribute User user) {
        userService.deleteUser(user);
    }
}

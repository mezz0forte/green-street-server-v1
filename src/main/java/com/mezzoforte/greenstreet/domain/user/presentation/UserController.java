package com.mezzoforte.greenstreet.domain.user.presentation;

import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.domain.user.presentation.dto.response.UserResponse;
import com.mezzoforte.greenstreet.domain.user.service.UserService;
import com.mezzoforte.greenstreet.global.annotation.AuthorizationCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @AuthorizationCheck
    @GetMapping("/my")
    public UserResponse getMyInfo(@RequestAttribute User user) {
        return userService.getUserInfo(user);
    }

    @AuthorizationCheck
    @DeleteMapping
    public void unregister(@RequestAttribute User user) {
        userService.deleteUser(user);
    }
}

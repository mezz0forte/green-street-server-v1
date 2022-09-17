package com.mezzoforte.greenstreet.domain.user.controller;

import com.mezzoforte.greenstreet.domain.user.domain.entity.User;
import com.mezzoforte.greenstreet.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public List<User> unregister() {
        return userService.deleteUser();
    }
}

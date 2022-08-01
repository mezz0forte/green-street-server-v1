package com.mezzoforte.greenstreet.user.controller;

import com.mezzoforte.greenstreet.common.response.Response;
import com.mezzoforte.greenstreet.common.response.ResponseData;
import com.mezzoforte.greenstreet.user.domain.entity.User;
import com.mezzoforte.greenstreet.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseData<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseData<>(HttpStatus.OK, "유저 조회 성공", users);
    }
}

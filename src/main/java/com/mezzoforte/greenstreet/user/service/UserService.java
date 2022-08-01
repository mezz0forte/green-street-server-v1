package com.mezzoforte.greenstreet.user.service;

import com.mezzoforte.greenstreet.user.domain.entity.User;
import com.mezzoforte.greenstreet.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

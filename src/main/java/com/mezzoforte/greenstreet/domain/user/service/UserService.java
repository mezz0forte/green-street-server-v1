package com.mezzoforte.greenstreet.domain.user.service;

import com.mezzoforte.greenstreet.domain.user.domain.repository.UserRepository;
import com.mezzoforte.greenstreet.domain.user.domain.entity.User;
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

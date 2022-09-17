package com.mezzoforte.greenstreet.domain.user.service;

import com.mezzoforte.greenstreet.domain.user.repository.UserRepository;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}

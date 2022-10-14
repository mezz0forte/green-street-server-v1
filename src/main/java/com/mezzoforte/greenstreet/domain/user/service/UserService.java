package com.mezzoforte.greenstreet.domain.user.service;

import com.mezzoforte.greenstreet.domain.user.presentation.dto.response.UserResponse;
import com.mezzoforte.greenstreet.domain.user.repository.UserRepository;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse getUserInfo(User user) {
        return new UserResponse(user.getId(), user.getPhone(), user.getImage(), user.getNickname());
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}

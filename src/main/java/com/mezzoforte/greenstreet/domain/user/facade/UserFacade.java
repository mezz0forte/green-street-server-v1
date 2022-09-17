package com.mezzoforte.greenstreet.domain.user.facade;

import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.domain.user.exception.UserNotFoundException;
import com.mezzoforte.greenstreet.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User queryUserByPhone(String phone) {
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}

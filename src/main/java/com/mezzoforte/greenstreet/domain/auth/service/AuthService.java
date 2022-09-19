package com.mezzoforte.greenstreet.domain.auth.service;

import com.mezzoforte.greenstreet.domain.auth.exception.PasswordNotMatchException;
import com.mezzoforte.greenstreet.domain.auth.exception.UserAlreadyExistsException;
import com.mezzoforte.greenstreet.domain.auth.presentation.dto.request.JoinRequest;
import com.mezzoforte.greenstreet.domain.auth.presentation.dto.request.LoginRequest;
import com.mezzoforte.greenstreet.domain.auth.presentation.dto.response.LoginTokenResponse;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.domain.user.facade.UserFacade;
import com.mezzoforte.greenstreet.domain.user.presentation.dto.response.UserResponse;
import com.mezzoforte.greenstreet.domain.user.repository.UserRepository;
import com.mezzoforte.greenstreet.domain.user.type.AccountType;
import com.mezzoforte.greenstreet.global.enums.JwtType;
import com.mezzoforte.greenstreet.global.lib.Jwt;
import com.mezzoforte.greenstreet.global.lib.encrypt.Encrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final Jwt jwt;
    private final Encrypt encrypt;

    @Transactional(rollbackFor = {Exception.class})
    public void join(JoinRequest request) {

        // TODO : 전화번호 인증

        request.getPhone().replaceAll("[^0-9]", "");

        if (userRepository.existsByPhone(request.getPhone())) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        String encryptedPassword = encrypt.encode(request.getPassword());
        User user = User.builder()
                .phone(request.getPhone())
                .nickname(request.getNickname())
                .image(request.getImage())
                .accountType(AccountType.NORMAL)
                .password(encryptedPassword)
                .build();

        userRepository.save(user);
    }

    @Transactional(rollbackFor = {Exception.class})
    public LoginTokenResponse login(LoginRequest request) {

        User user = userFacade.queryUserByPhone(request.getPhone());
        if (!encrypt.match(request.getPassword(), user.getPassword())) {
            throw PasswordNotMatchException.EXCEPTION;
        }

        String accessToken = jwt.createToken(user, JwtType.ACCESS);
        String refreshToken = jwt.createToken(user, JwtType.REFRESH);

        return new LoginTokenResponse(
                new UserResponse(user.getId(), user.getPhone(), user.getImage(), user.getNickname()),
                accessToken,
                refreshToken);
    }
}

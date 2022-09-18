package com.mezzoforte.greenstreet.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mezzoforte.greenstreet.domain.user.type.AccountType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20, unique = true)
    private String phone;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private String nickname;

    @JsonIgnore
    @Size(max = 150)
    private String password;

    @Column(nullable = false)
    private String image;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Builder
    public User(String phone, String nickname, String image, AccountType accountType) {
        this.phone = phone;
        this.nickname = nickname;
        this.image = image;
        this.accountType = accountType;
    }
}

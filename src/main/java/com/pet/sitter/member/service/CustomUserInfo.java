package com.pet.sitter.member.service;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class CustomUserInfo extends org.springframework.security.core.userdetails.User {

    private final String name;
    private final String memberId;
    private final String nickname;

    public CustomUserInfo(String username, String password,
                          Collection<? extends GrantedAuthority> authorities,
                          String name, String memberId, String nickname) {
        super(username, password, authorities);
        this.name = name;
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
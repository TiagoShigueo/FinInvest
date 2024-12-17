package com.back.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Auth {
    @Setter
    @Getter
    private String login;

    @Setter
    @Getter
    private String password;
}

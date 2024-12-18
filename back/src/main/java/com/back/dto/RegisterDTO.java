package com.back.dto;

import com.back.enums.UserRole;

public record RegisterDTO(String login, String password, String name, UserRole role) {

}

package com.example.cardapio.domain.user.dto;

import com.example.cardapio.domain.user.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}

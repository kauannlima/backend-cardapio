package com.example.cardapio.domain.food.dto;

public record FoodRequestDTO(
        String title,
        String image,
        Integer price
) {
}

package com.example.cardapio.food.dto;

public record FoodRequestDTO(
        String title,
        String image,
        Integer price
) {
}

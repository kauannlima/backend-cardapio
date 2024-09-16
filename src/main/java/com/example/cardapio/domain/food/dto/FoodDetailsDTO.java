package com.example.cardapio.domain.food.dto;

import com.example.cardapio.domain.food.Food;

public record FoodDetailsDTO(
        String title,
        String image,
        Integer price
) {
    public FoodDetailsDTO(Food food) {
        this(food.getTitle(), food.getImage(), food.getPrice());
    }

}

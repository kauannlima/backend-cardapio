package com.example.cardapio.food.dto;

import com.example.cardapio.food.Food;

public record FoodDetailsDTO(
        String title,
        String image,
        Integer price
) {
    public FoodDetailsDTO(Food food) {
        this(food.getTitle(), food.getImage(), food.getPrice());
    }

}

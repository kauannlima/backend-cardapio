package com.example.cardapio.food;

import com.example.cardapio.food.dto.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity(name = "foods")
@Table(name = "foods")
public class Food {

    public Food(FoodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;
}

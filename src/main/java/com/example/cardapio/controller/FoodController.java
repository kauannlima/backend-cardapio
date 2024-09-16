package com.example.cardapio.controller;

import com.example.cardapio.domain.food.Food;
import com.example.cardapio.service.FoodService;
import com.example.cardapio.domain.food.dto.FoodDetailsDTO;
import com.example.cardapio.domain.food.dto.FoodIdDTO;
import com.example.cardapio.domain.food.dto.FoodRequestDTO;
import com.example.cardapio.domain.food.dto.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public  ResponseEntity<List<FoodResponseDTO>> getAll() {
        List<FoodResponseDTO> foodList = service.getAll();
        return ResponseEntity.ok(foodList);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{foodId}")
    public ResponseEntity<FoodDetailsDTO> getFoodById(@PathVariable Long foodId) {
        FoodDetailsDTO food = service.getFoodById(foodId);
        return ResponseEntity.ok(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<FoodIdDTO> saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        FoodIdDTO foodResponseDTOId = service.saveFood(foodData);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodResponseDTOId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{foodId}")
    public ResponseEntity<FoodDetailsDTO> updateFood(@PathVariable Long foodId, @RequestBody FoodRequestDTO data){
        FoodDetailsDTO food = service.updateFood(foodId, data);
        return ResponseEntity.ok(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long foodId){
        service.deleteFood(foodId);
        return ResponseEntity.noContent().build();
    }
}

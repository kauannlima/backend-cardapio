package com.example.cardapio.food;

import com.example.cardapio.exception.FoodNotFoundException;
import com.example.cardapio.food.dto.FoodDetailsDTO;
import com.example.cardapio.food.dto.FoodIdDTO;
import com.example.cardapio.food.dto.FoodRequestDTO;
import com.example.cardapio.food.dto.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository repository;

    //GET
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    //GET
    public FoodDetailsDTO getFoodById(Long foodId) {
        Food food = repository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoundException("Food com id " + foodId + " não encontrada"));
        return new FoodDetailsDTO(food);
    }

    //POST
    public FoodIdDTO saveFood(Food foodData) {
        Food food = repository.save(foodData);
        FoodIdDTO foodResponseDTOId = new FoodIdDTO(foodData.getId());
        return foodResponseDTOId;
    }

    //PUT
    public FoodDetailsDTO updateFood(Long foodId, FoodRequestDTO data) {
        Food food = repository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoundException("Food com id " + foodId + " não encontrada"));

        food.setPrice(data.price() == null ? food.getPrice() : data.price());
        food.setTitle(data.title()== null  ? food.getTitle() : data.title());
        food.setImage(data.image()== null  ? food.getImage() : data.image());



        repository.save(food);

        return new FoodDetailsDTO(food);
    }

    public void deleteFood(Long foodId) {
        Food food = repository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoundException("Food com id " + foodId + " não encontrada"));
        repository.delete(food);
    }
}

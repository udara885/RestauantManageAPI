package com.example.RestaurantManageAPI.service;

import com.example.RestaurantManageAPI.entity.Food;
import com.example.RestaurantManageAPI.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    public Food addFoodDB(Food food){
        return foodRepository.save(food);
    }
    public List<Food> addFoodsDB(List<Food> food){
        return foodRepository.saveAll(food);
    }
    public List<Food> viewFoods(){
        return foodRepository.findAll();
    }
    public Food viewFood(int id){
        return foodRepository.findById(id).orElse(null);
    }
    public Food updateFoodDB(Food food, int id) {
        Food existingFood = foodRepository.findById(id).orElse(null);
        if (existingFood == null) {
            return null;
        }
        existingFood.setFname(food.getFname());
        existingFood.setPrice(food.getPrice());
        return foodRepository.save(existingFood);
    }
    public String deleteFood(int id){
        foodRepository.deleteById(id);
        return "deleted";
    }
}

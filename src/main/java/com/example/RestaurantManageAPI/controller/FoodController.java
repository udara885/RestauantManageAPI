package com.example.RestaurantManageAPI.controller;

import com.example.RestaurantManageAPI.entity.Food;
import com.example.RestaurantManageAPI.repository.FoodRepository;
import com.example.RestaurantManageAPI.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/food")

public class FoodController {
    @Autowired
    private FoodService foodService;
    private FoodRepository foodRepository;
    @PostMapping("/addFood")
    public Food addFood(@RequestBody Food food){
        return foodService.addFoodDB(food);
    }
    @PostMapping("/addFoods")
    public List<Food> addFoods(@RequestBody List<Food> food){
        return foodService.addFoodsDB(food);
    }
    @GetMapping("/viewFoods")
    public List<Food> viewFoods(){
        return foodService.viewFoods();
    }
    @GetMapping("/viewFood/{id}")
    public Food viewFood(@PathVariable int id){
        return foodService.viewFood(id);
    }
    @PutMapping("/updateFood/{id}")
    public Food updateFood(@RequestBody Food food, @PathVariable int id) {
        return foodService.updateFoodDB(food, id);
    }
    @DeleteMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable int id ){
        return foodService.deleteFood(id);
    }
}

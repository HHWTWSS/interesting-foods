package com.github.interview.controller;

import com.github.interview.model.Food;
import com.github.interview.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/foodList", method = RequestMethod.GET)
    public List<Food> getFoodList() {
        return foodService.getFoodList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getOneFood(@PathVariable("id") Integer id) {
        return foodService.getFood(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFood(@RequestBody Food  food) {
        return foodService.save(food);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        return foodService.removeFood(id);
    }
}

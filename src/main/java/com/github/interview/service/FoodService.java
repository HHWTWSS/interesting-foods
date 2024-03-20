package com.github.interview.service;

import com.github.interview.model.Food;
import com.github.interview.raeder.FoodDataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodDataReader reader;

    public List<Food> getFoodList() {
        return reader.getData();
    }

    public Food getFood(Integer id) {
        return reader.getData().stream().filter(x -> x.getLocationId().equals(id)).findFirst().get();
    }

    public String removeFood(Integer id) {
        long count = reader.getData().stream().filter(x -> x.getLocationId().equals(id)).count();
        if (count == 0) {
            return "removed Failed";
        } else {
            Food food = reader.getData().stream().filter(x -> x.getLocationId().equals(id)).findFirst().get();
            reader.getData().remove(food);
            return "removed Successfully";
        }

    }

    public String save(Food food) {
        long count = reader.getData().stream().filter(x -> x.getLocationId().equals(food.getLocationId())).count();
        if (count == 0) {
            reader.getData().add(food);
            return "added  Successfully";
        } else {
            Food existedFood = reader.getData().stream().filter(x -> x.getLocationId().equals(food.getLocationId())).findFirst().get();
            int index = reader.getData().indexOf(existedFood);
            reader.getData().set(index, food);
            return "updated Successfully";
        }
    }
}

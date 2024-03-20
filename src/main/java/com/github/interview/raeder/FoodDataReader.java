package com.github.interview.raeder;

import com.github.interview.model.Food;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class FoodDataReader {

    private FoodDataReader() {
    }

    ;
    private static FoodDataReader foodDataReader = new FoodDataReader();

    @Autowired
    private ResourceLoader resourceLoader;
    private List<Food> data = new CopyOnWriteArrayList<>();

    public static FoodDataReader getFoodDataReader() {
        return foodDataReader;
    }

    public List<Food> getData() {
        return data;
    }

    public void setData(List<Food> data) {
        this.data = data;
    }

    @PostConstruct
    public void readCsvFile() {
        try {
            Resource resource = resourceLoader.getResource("classpath:data/Mobile_Food_Facility_Permit.csv");
            InputStream inputStream = resource.getInputStream();
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            try {
                reader.readNext();
                String[] foodAttrArray = null;
                while ((foodAttrArray = reader.readNext()) != null) {
                    Food food = new Food();
                    food.setLocationId(Integer.parseInt(foodAttrArray[0]));
                    food.setApplicant(foodAttrArray[1]);
                    food.setFacilityType(foodAttrArray[2]);
                    food.setCnn(foodAttrArray[3]);
                    food.setLocationDescription(foodAttrArray[4]);
                    food.setAddress(foodAttrArray[5]);
                    food.setBlockLot(foodAttrArray[6]);
                    food.setBlock(foodAttrArray[7]);
                    food.setLot(foodAttrArray[8]);
                    food.setPermit(foodAttrArray[9]);
                    food.setStatus(foodAttrArray[10]);
                    food.setFoodItems(foodAttrArray[11]);
                    food.setX(foodAttrArray[12]);
                    food.setY(foodAttrArray[13]);
                    food.setLatitude(foodAttrArray[14]);
                    food.setLongitude(foodAttrArray[15]);
                    food.setSchedule(foodAttrArray[16]);
                    food.setDaysHours(foodAttrArray[17]);
                    food.setNoiSent(foodAttrArray[18]);
                    food.setApproved(foodAttrArray[19]);
                    food.setReceived(foodAttrArray[20]);
                    food.setPriorPermit(foodAttrArray[21]);
                    food.setExpirationDate(foodAttrArray[22]);
                    food.setLocation(foodAttrArray[23]);
                    food.setFirePreventionDistricts(foodAttrArray[24]);
                    food.setPoliceDistricts(foodAttrArray[25]);
                    food.setSupervisorDistricts(foodAttrArray[26]);
                    food.setZipCodes(foodAttrArray[27]);
                    food.setNeighborhoodsOld(foodAttrArray[28]);
                    data.add(food);
                }
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package models.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

public record RatingProduct(
    @JsonProperty("rate") double rate, 
    @JsonProperty("count") int count
) {
    public static RatingProduct generateRating(){
        Faker faker = new Faker(); 
        
        double rate = faker.number().randomDouble(2, 1, 50); 
        int count = faker.random().nextInt(10, 30); 

        return new RatingProduct(rate, count); 
    } 
    
}


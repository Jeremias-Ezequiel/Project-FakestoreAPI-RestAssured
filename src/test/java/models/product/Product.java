package models.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

public record Product(
    @JsonProperty("title") String title,
    @JsonProperty("price") double price,
    @JsonProperty("category") String category, 
    @JsonProperty("description") String description, 
    @JsonProperty("image") String image 
) {
    public static Product generateProduct(){
        Faker faker = new Faker(); 
    
        final String title = faker.commerce().productName(); 
        final double price = faker.number().randomDouble(2, 5, 20); 
        final String category = faker.commerce().department(); 
        final String description = faker.lorem().paragraph(2); 
        final String image = "https://i.pravatar.cc/"; 

        return new Product(title, price, category, description, image); 
    }
}

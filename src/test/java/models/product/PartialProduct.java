package models.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PartialProduct(
    @JsonProperty("title") String title,
    @JsonProperty("price") Double price,
    @JsonProperty("category") String category, 
    @JsonProperty("description") String description, 
    @JsonProperty("image") String image 
) {
    public boolean isValid(){
        return title != null || price != null || category != null || description != null || image != null;
    }

    public static PartialProduct generatePartialProduct(){
        Faker faker = new Faker(); 
        
        boolean updateTitle = faker.bool().bool(); 
        boolean updatePrice = faker.bool().bool(); 
        boolean updateCategory = faker.bool().bool(); 
        boolean updateDescription = faker.bool().bool(); 
        boolean updateImage = faker.bool().bool(); 
    
        return new PartialProduct(
            updateTitle ? faker.commerce().productName() : null,
            updatePrice ? faker.number().randomDouble(2,5,20) : null,
            updateCategory ? faker.commerce().department() : null,
            updateDescription ? faker.lorem().paragraph(2) : null,
            updateImage ? "https://i.pravatar.cc/" : null
        ); 
    }
}

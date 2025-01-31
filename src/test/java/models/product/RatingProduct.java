package models.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RatingProduct(
    @JsonProperty("rate") double rate, 
    @JsonProperty("count") int count
) {

}

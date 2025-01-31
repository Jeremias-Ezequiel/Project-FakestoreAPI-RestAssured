package models.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductGetResponse(
    @JsonProperty("id") int id,
    @JsonProperty("title") String title,
    @JsonProperty("price") double price,
    @JsonProperty("category") String category, 
    @JsonProperty("description") String description, 
    @JsonProperty("image") String image,
    @JsonProperty("rating") RatingProduct rating
) {

}

package me.sloowy.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.sloowy.literalura.models.dto.AuthorDTO;
import me.sloowy.literalura.models.dto.BookDTO;

public class DataConverter implements IDataConverter {

    private final ObjectMapper mapper = new ObjectMapper();

    public BookDTO convertData(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        var tree = mapper.readTree(json);
        var jsonBook = tree.get("results").get(0);

        return mapper.treeToValue(jsonBook, BookDTO.class);
    }

    @Override
    public <T> T convertData(String json, Class<T> className) {
        try {
            JsonNode tree = mapper.readTree(json);
            if (className == BookDTO.class) {
                var result = tree.get("results").get(0);
                return mapper.treeToValue(result, className);
            } else if (className == AuthorDTO.class) {
                var result = tree.get("results").get(0).get("authors").get(0);
                return mapper.treeToValue(result, className);
            } else {
                return mapper.readValue(json, className);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

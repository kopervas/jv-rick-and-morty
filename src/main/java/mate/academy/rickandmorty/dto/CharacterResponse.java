package mate.academy.rickandmorty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import mate.academy.rickandmorty.model.CharacterRM;

@Data
public class CharacterResponse {
    private Info info;
    @JsonProperty("results")
    private List<CharacterRM> results;

    @Data
    public static class Info {
        private int count;
        private int pages;
        private String next;
        private String prev;
    }
}

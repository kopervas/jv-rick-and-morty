package mate.academy.rickandmorty.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.CharacterResponse;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private static final String URL = "https://rickandmortyapi.com/api/character";
    private final CharacterRepository characterRepository;

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String jsonResponse = responseEntity.getBody();
        CharacterResponse response = objectMapper.readValue(jsonResponse, CharacterResponse.class);
        characterRepository.saveAll(response.getResults());
        System.out.println(response.toString());
    }
}

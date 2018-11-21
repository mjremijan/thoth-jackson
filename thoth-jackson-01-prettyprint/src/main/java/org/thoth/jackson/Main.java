package org.thoth.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String jsonStr 
            = Files.readAllLines(Paths.get("./src/main/resources/genesis1.json"))
                .stream().reduce((t,v) -> t + " " + v)
                .get()
        ;
        
        // Pretty print with Jackson
        ObjectMapper mapper = new ObjectMapper();
        Object json = mapper.readValue(jsonStr, Object.class);
        
        System.out.printf(
                "%n%nPretty Print:%n%s%n"
                , mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json)
        );
    }
}

package org.thoth.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.thoth.jackson.chapter.Chapter;

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
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Chapter chapter = mapper.readValue(jsonStr, Chapter.class);
        
        System.out.printf(
                "%n%nBinding:%n%s%n"
                , chapter.toString()
        );
    }
}

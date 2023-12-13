package de.kaharo.backend.doitkids;

import org.springframework.data.annotation.Id;

public record Kids (

        @Id
        String id,
        String name,
        Integer age,
        Boolean indoor,
        Boolean outdoor,
        Integer groupSize,
        Boolean sporty,
        Boolean educational,
        // Using float for decimal numbers, as we need to represent values like "10,50€"
        Float cost
){
}

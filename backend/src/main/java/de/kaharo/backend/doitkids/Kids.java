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
        // Explanation:
        // - name: Name of the activity like playground or oen-air bath
        // - age: Age of the kid.
        // - indoor: Whether the kid likes indoor activities.
        // - outdoor: Whether the kid likes outdoor activities.
        // - groupSize: Depending on the size of the group some activities are not possible.
        // - sporty: Whether the kid is sporty (can be null if not specified).
        // - educational: Whether the kid is educational (can be null if not specified).
        // - cost:When ever an activity should be cost something it's useful to have a Float it could be null also
}

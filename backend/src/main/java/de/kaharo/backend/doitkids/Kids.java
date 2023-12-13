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
        // - name: Name of the activity, such as playground or open-air bath.
        // - age: Age of the kid.
        // - indoor: Indicates whether the kid enjoys indoor activities.
        // - outdoor: Indicates whether the kid enjoys outdoor activities.
        // - groupSize: Depending on the group size, some activities may not be possible.
        // - sporty: Indicates whether the kid is sporty (can be null if not specified).
        // - educational: Indicates whether the kid is inclined towards educational activities (can be null if not specified).
        // - cost: Represents the cost of the activity (can be null if not applicable).
}

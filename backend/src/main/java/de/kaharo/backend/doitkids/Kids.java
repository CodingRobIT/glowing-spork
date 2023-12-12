package de.kaharo.backend.doitkids;

import org.springframework.data.annotation.Id;

public record Kids (

        @Id
        String id
){
}

package de.kaharo.backend.doitComments;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

// when this record should be used in Multiple Modells we should place that in the doIt Package
public record CommentList(

        @Id
        String id,
        String activityId,
        String user,
        LocalDateTime commentDate,
        String comment,
        Boolean approved // only approved comments can be public have to be handled in the Frontend
) {
}

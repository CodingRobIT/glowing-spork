package de.kaharo.backend.doitkids;

import de.kaharo.backend.doitComments.CommentList;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

import java.util.List;

public record KidsActivity(

        @Id
        String id,
        @NotBlank(message = "Name is required")
        @Size(min = 4, max = 1000)
        String name,
        // should we add Max Age here ?
        // Byte because it needs less ram and the number is big enough for an minAge
        Byte minAge,
        Boolean indoor,
        Boolean outdoor,
        Byte groupSize,
        Boolean sporty,
        Boolean educational,
        // Using float for decimal numbers, as we need to represent values like "10,50€"
        Float cost,
        String location,
        // String descriptionActivity,
        // now here ist the "import" of CommentList that we could use now for this model
        List<CommentList> comments
) {
        // Explanation:
        // - name: Name of the activity, such as playground or open-air bath.
        // - age: Age of the kid.
        // - indoor: for indoor activities.
        // - outdoor: for outdoor activities.
        // - groupSize: Depending on the group size, some activities may not be possible.
        // - sporty: for sporty activity (can be null if not specified).
        // - educational: for educational activities (can be null if not specified).
        // - cost: Represents the cost of the activity (can be null if not applicable).
        // - location to get the position of the place
}


// How to use the CommentList here is an explanation:

// for (CommentList comment: kidsActivity.comments()) {
//    // Zugriff auf den Nutzernamen des Kommentars
//    System.out.println("User: " + comment.user());
//
//    // Zugriff auf das Datum des Kommentars
//    System.out.println("Datum: " + comment.commentDate());
//
//    // Zugriff auf den Kommentartext
//    System.out.println("Kommentar: " + comment.comment());
//
//    // Überprüfen, ob der Kommentar genehmigt wurde
//    System.out.println("Genehmigt: " + comment.approved());
//}
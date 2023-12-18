package de.kaharo.backend.doitkids;

import de.kaharo.backend.doitComments.CommentList;
//import de.kaharo.backend.doitComments.CommentListRepoInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DoitKidsService {

    private final KidsActivityRepoInterface kidsActivityRepoInterface;

    // Without Exception
//    public List<KidsActivity> getAllKidsActivity() {
//        return kidsActivityRepoInterface.findAll();
//    }

    // With Exception
    public List<KidsActivity> getAllKidsActivity() {
        List<KidsActivity> activities = kidsActivityRepoInterface.findAll();

        if (activities.isEmpty()) {
            throw new NoSuchElementException("No kids activities found");
        }

        return activities;
    }

//    public KidsActivity getKidsActivityWithComments(String activityId) {
//        // Zuerst die KidsActivity anhand der ID finden
//        Optional<KidsActivity> activityOpt = kidsActivityRepoInterface.findById(activityId);
//
//        if (activityOpt.isPresent()) {
//            KidsActivity activity = activityOpt.get();
//
//            // Kommentare, die die gleiche activityId haben, finden
//            List<CommentList> comments = CommentListRepoInterface.findByActivityId(activityId);
//
//            // Erstelle eine neue KidsActivity mit den Kommentaren
//            return new KidsActivity(activity.id(),activity.name(),activity.minAge(),activity.indoor(),activity.outdoor(), activity.groupSize(), activity.sporty(),activity.educational(),activity.cost(),activity.location(),comments); // Fülle die restlichen Felder entsprechend aus
//        } else {
//            throw new NoSuchElementException("KidsActivity with ID " + activityId + " not found");
//        }
//    }
}

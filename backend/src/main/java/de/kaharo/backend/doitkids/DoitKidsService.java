package de.kaharo.backend.doitkids;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

}

package de.kaharo.backend.doitkids;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoitKidsService {

    private final KidsActivityRepoInterface kidsActivityRepoInterface;

    public List<KidsActivity> getAllKidsActivitys() {
        return KidsActivityRepoInterface.findAll();
    }
}

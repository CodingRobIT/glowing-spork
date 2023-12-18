package de.kaharo.backend.doitkids;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kidsactivity")
public class DoitKidsController {

    private final DoitKidsService kidsService;

    @GetMapping
    public List<KidsActivity> getAllKidsActivity() {
        return kidsService.getAllKidsActivity();
    }

    // Post Mapping works let it disabled for later ?
//    @PostMapping
//    public KidsActivity addKidsActivity(@RequestBody KidsActivity kidsActivityToAdd) {
//        return kidsService.addKidsActivity(kidsActivityToAdd);
//    }
}

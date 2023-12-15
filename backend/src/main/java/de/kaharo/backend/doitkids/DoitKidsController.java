package de.kaharo.backend.doitkids;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

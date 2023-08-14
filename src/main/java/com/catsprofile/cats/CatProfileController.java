package com.catsprofile.cats;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class CatProfileController {

    @GetMapping("profiles1")
    public List<String> getProfiles() {
        return List.of("Roku", "Tom", "Lucca", "Hinata", "Bungaku");
    }

    // 生年月日も受け取れるようにする
    @GetMapping("/profiles2")
    public List<CatProfile> catProfileList() {
        return List.of(new CatProfile("Roku", LocalDate.of(2019, 6, 9), "黒色"),
                new CatProfile("Tom", LocalDate.of(2022, 4, 10), "グレー＆白色"));
    }

    // クエリ文字を受け取れるようにする
    @GetMapping("/profiles3")
    public String catName(
            @RequestParam String name) {
        return "Lucca";
    }


    @PostMapping("/profiles")
    public ResponseEntity<ProfileCreateResponse> createProfile(@RequestBody CatProfileCreateForm catProfileCreateForm) {

        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/profiles")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(new ProfileCreateResponse("profile successfully created"));

    }

    @PatchMapping("/profiles/{id}")
    public ResponseEntity<Map<String, String>> updateProfile(@PathVariable("id") int id, @RequestBody CatProfileUpdateForm catProfileUpdateForm) {
        return ResponseEntity.ok(Map.of("message", "profile successfully updated"));
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Map<String, String>> deleteName(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "profile successfully deleted"));
    }
}

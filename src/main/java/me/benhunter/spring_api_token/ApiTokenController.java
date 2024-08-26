package me.benhunter.spring_api_token;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class ApiTokenController {

    @PostMapping("/generate")
    public ResponseEntity<ApiToken> generateApiToken() {
        ApiToken token = new ApiToken();
        return ResponseEntity.ok(token);
    }
}

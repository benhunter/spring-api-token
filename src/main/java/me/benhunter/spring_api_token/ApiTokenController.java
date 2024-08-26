package me.benhunter.spring_api_token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class ApiTokenController {

    @Autowired
    private ApiTokenService apiTokenService;

    @PostMapping("/generate")
    public ResponseEntity<ApiToken> generateApiToken() {
        ApiToken token = apiTokenService.generateToken();
        return ResponseEntity.ok(token);
    }
}

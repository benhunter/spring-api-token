package me.benhunter.spring_api_token;

import org.springframework.stereotype.Service;

@Service
public class ApiTokenService {
    public ApiToken generateToken() {
        return new ApiToken();
    }
}

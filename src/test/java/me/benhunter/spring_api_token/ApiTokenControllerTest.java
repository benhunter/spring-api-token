package me.benhunter.spring_api_token;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiTokenController.class)
class ApiTokenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiTokenService apiTokenService;

    @Test
    @WithMockUser
    void testGenerateToken() throws Exception {
        ApiToken token = new ApiToken();
        when(apiTokenService.generateToken()).thenReturn(token);

        mockMvc.perform(
                post("/api/token/generate")
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(token.getToken()));
    }
}

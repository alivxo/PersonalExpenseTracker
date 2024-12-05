package com.expense.tracker.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.expense.tracker.Models.User;
import com.expense.tracker.Service.UserService;
import com.expense.tracker.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AuthControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @MockBean
  private JwtUtil jwtUtil;

  @MockBean
  private AuthenticationManager authenticationManager;

  @Test
  public void testRegisterUser_Success() throws Exception {
    Map<String, String> payload = new HashMap<>();
    payload.put("name", "example");
    payload.put("username", "Example123");
    payload.put("email", "example@example.com");
    payload.put("password", "Password@123");

    String jsonPayload = new ObjectMapper().writeValueAsString(payload);

    Mockito.when(userService.registerUser(Mockito.any(User.class))).thenReturn(new User());

    mockMvc
        .perform(
            post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("User Registered Successfully"));
  }

  @Test
  public void testLoginUser_success() throws Exception {
    User newUser = new User();
    newUser.setEmail("example@example.com");
    newUser.setUsername("username");
    newUser.setPassword("Login@123");
    userService.registerUser(newUser);

    HashMap<String, String> loginPayload = new HashMap<>();
    loginPayload.put("username", "username");
    loginPayload.put("password", "Login@123");

    String jsonLogingPayload = new ObjectMapper()
        .writeValueAsString(loginPayload);

    MockHttpServletRequestBuilder loginRequestBuilder = post("/api/auth/login")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(jsonLogingPayload);

    mockMvc
        .perform(loginRequestBuilder)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Successfully logged in !!!"));
  }
}

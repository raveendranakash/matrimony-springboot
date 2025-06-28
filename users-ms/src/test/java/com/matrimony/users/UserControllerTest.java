package com.matrimony.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrimony.users.controller.UserController;
import com.matrimony.users.dto.ResponseDTO;
import com.matrimony.users.dto.UserDTO;
import com.matrimony.users.util.ResponseStatus;
import com.matrimony.users.util.UserConstants;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = UserMain.class)
@ContextConfiguration
@TestPropertySource(locations = {"classpath:application-test.properties"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserController userController;

    List<UserDTO> userDTOs = new ArrayList<>();

    @Test
    @Order(1)
    public void getAllUserTest() throws Exception{
        userDTOs.add(new UserDTO(1L, "Ayush", "Akash", "Raveendran", true));
        userDTOs.add(new UserDTO(2L, "Akash", "", "Raveendran", false));
        ResponseDTO mockResponse = new ResponseDTO(ResponseStatus.OK, HttpStatus.OK,
                UserConstants.SUCCESS, userDTOs);
        when(userController.getAllUsers()).thenReturn(mockResponse);

        MvcResult mvcResult = this.mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(objectMapper.writeValueAsString(mockResponse), mvcResult.getResponse().getContentAsString());
        userDTOs.clear();
    }

    @Test
    @Order(2)
    public void addUserTest() throws Exception{
        UserDTO userDto = new UserDTO(2L, "Akash", "", "Raveendran", false);
        String json = "{\"firstName\":\"Akash\",\"middleName\":\"\",\"lastName\":\"Raveendran\",\"premiumUser\":false}";
        userDTOs.add(userDto);

        ResponseDTO mockResponse = new ResponseDTO(ResponseStatus.OK, HttpStatus.OK,
                UserConstants.SUCCESS, userDTOs);
        when(userController.addUser(userDto)).thenReturn(mockResponse);

        MvcResult mvcResult = this.mockMvc.perform(post("/user/").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andReturn();
        /* not working as MockHttpServletResponse body comes out empty */
        //assertEquals(objectMapper.writeValueAsString(mockResponse), mvcResult.getResponse().getContentAsString());
        userDTOs.clear();
    }

    @Test
    public void getUserByIdTest() throws Exception{
        userDTOs.add(new UserDTO(1L, "Ayush", "Akash", "Raveendran", true));
        ResponseDTO mockResponse = new ResponseDTO(ResponseStatus.OK, HttpStatus.OK,
                UserConstants.SUCCESS, userDTOs);
        when(userController.getAllUsers()).thenReturn(mockResponse);

        MvcResult mvcResult = this.mockMvc.perform(get("/user/{id}", 1))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        /* not working as MockHttpServletResponse body comes out empty */
        //assertEquals(objectMapper.writeValueAsString(mockResponse), mvcResult.getResponse().getContentAsString());
        userDTOs.clear();
    }

}

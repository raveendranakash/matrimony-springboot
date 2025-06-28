package com.matrimony.users.controller;

import com.matrimony.users.dto.ResponseDTO;
import com.matrimony.users.dto.UserDTO;
import com.matrimony.users.service.UserService;
import com.matrimony.users.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.matrimony.users.util.UserConstants.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseDTO getUserById(@PathVariable Long id){
        List<UserDTO> users = new ArrayList<>();
        users.add(userService.fetchUserById(id));
        return new ResponseDTO(ResponseStatus.OK, HttpStatus.OK, SUCCESS, users);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseDTO getAllUsers(){
        List<UserDTO> users = userService.fetchAllUsers();
        return new ResponseDTO(ResponseStatus.OK, HttpStatus.OK, SUCCESS, users);
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseDTO addUser(@RequestBody UserDTO userDTO){
        List<UserDTO> users = new ArrayList<>();
        users.add(userService.saveUser(userDTO));
        return new ResponseDTO(ResponseStatus.OK, HttpStatus.OK, SUCCESS, users);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        List<UserDTO> users = new ArrayList<>();
        users.add(userService.updateUser(id, userDTO));
        return new ResponseDTO(ResponseStatus.OK, HttpStatus.OK, SUCCESS, users);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseDTO(ResponseStatus.OK, HttpStatus.OK, SUCCESS, new ArrayList<UserDTO>());
    }

}

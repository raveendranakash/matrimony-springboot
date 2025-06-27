package com.matrimony.users.service;

import com.matrimony.users.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO user);

    UserDTO fetchUserById(Long userId);

    List<UserDTO> fetchAllUsers();

    UserDTO updateUser(Long userId, UserDTO user);

    void deleteUser(Long userId);

}

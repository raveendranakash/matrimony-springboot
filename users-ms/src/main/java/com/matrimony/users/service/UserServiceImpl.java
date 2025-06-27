package com.matrimony.users.service;

import com.matrimony.users.dao.UserDAO;
import com.matrimony.users.dto.UserDTO;
import com.matrimony.users.model.User;
import com.matrimony.users.util.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO<User> userDAO;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user = userDAO.save(user);
        return convertToDTO(user);
    }

    @Override
    public UserDTO fetchUserById(Long userId) {
        User user = null;
        try {
            user = userDAO.getById(userId);
        } catch (Exception e) {
            Log.print("Exception class is : "+e.getClass());
        }
        if (user!=null)
            return convertToDTO(user);
        else
            return new UserDTO();
    }

    @Override
    public List<UserDTO> fetchAllUsers() {
        List<User> users = new ArrayList<>();
        List<UserDTO> userDTOList = new ArrayList<>();
        users = userDAO.findAll();
        userDTOList = users.stream()
                            .map(this::convertToDTO)
                            .collect(Collectors.toList());
        return null;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user.setId(userId);
        user = userDAO.save(user);
        return convertToDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userDAO.getById(userId);
        userDAO.delete(user);
    }

    private UserDTO convertToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    private User convertToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

}

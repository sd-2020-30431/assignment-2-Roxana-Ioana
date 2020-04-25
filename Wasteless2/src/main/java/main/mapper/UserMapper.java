package main.mapper;

import main.dto.*;
import main.model.*;

public class UserMapper {

    public User convertToUser(UserDTO userDTO)
    {
        User user = new User();

        user.setIdUser(userDTO.getIdUser());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setDailyCalories(userDTO.getDailyCalories());

        return user;
    }

    public UserDTO convertToDTO(User user)
    {
        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser(user.getIdUser());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setDailyCalories(user.getDailyCalories());

        return userDTO;
    }
}

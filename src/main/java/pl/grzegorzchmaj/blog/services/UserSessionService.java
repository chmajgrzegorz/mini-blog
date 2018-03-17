package pl.grzegorzchmaj.blog.services;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.grzegorzchmaj.blog.model.dtos.UserDTO;
import pl.grzegorzchmaj.blog.model.entities.User;
import pl.grzegorzchmaj.blog.repositories.UserRepository;

import java.util.Optional;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionService {

    private boolean logged;
    private UserDTO userDto;

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public boolean loginUser(String username, String password){
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(!optionalUser.isPresent()){
            return false;
        }

        User user = optionalUser.get();

        if(!user.getPassword().equals(password)){
            return false;
        }

        userDto = modelMapper.map(user, UserDTO.class);
        logged = true;
        return logged;
    }

    //====================================Get,Set,Const====================================//
    
    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public UserDTO getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDTO userDto) {
        this.userDto = userDto;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}

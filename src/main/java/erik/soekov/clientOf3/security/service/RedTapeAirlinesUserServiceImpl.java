package erik.soekov.clientOf3.security.service;

import erik.soekov.clientOf3.security.dto.UserDTO;
import erik.soekov.clientOf3.security.exception.PasswordMismatchException;
import erik.soekov.clientOf3.security.exception.UsernameExistsException;
import erik.soekov.clientOf3.security.model.User;
import erik.soekov.clientOf3.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RedTapeAirlinesUserServiceImpl implements RedTapeAirlinesUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDTO userDTO) throws UsernameExistsException, PasswordMismatchException {
        User user = null;
        if(!userDTO.isPasswordMatch()){
            throw new PasswordMismatchException();
        }

        user = this.userRepository.findByUsername(userDTO.getUsername());
        if(user == null){
            userDTO.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
            this.userRepository.save(new User(userDTO));
        }else{
            throw new UsernameExistsException();
        }
        User user2 = this.userRepository.findByUsername(userDTO.getUsername());
        System.out.println(user2.getUsername() + " " + user2.getPassword() + " " + user2.getEmail());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByAuthentication(Authentication authentication) {
        return this.userRepository.findByUsername(authentication.getName());
    }
}

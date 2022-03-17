package erik.soekov.clientOf3.security.service;

import erik.soekov.clientOf3.security.dto.UserDTO;
import erik.soekov.clientOf3.security.exception.PasswordMismatchException;
import erik.soekov.clientOf3.security.exception.UsernameExistsException;
import erik.soekov.clientOf3.security.model.RedTapeAirlinesUserDetails;
import erik.soekov.clientOf3.security.model.User;
import erik.soekov.clientOf3.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RedTapeAirlinesUserDetailsService implements UserDetailsService, RedTapeAirlinesUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDTO userDTO) throws UsernameExistsException, PasswordMismatchException {
        User user = null;
        if(!userDTO.password.equals(userDTO.matchingPassword)){
            throw new PasswordMismatchException();
        }

        user = this.userRepository.findByUsername(userDTO.username);
        if(user == null){
            userDTO.password = this.passwordEncoder.encode(userDTO.password);
            this.userRepository.save(new User(userDTO));
        }else{
            throw new UsernameExistsException();
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByAuthentication(Authentication authentication) {
        return this.userRepository.findByUsername(authentication.getName());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }

        return new RedTapeAirlinesUserDetails(user);
    }
}

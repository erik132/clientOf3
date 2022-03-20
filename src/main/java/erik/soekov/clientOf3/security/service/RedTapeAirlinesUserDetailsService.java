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
import org.springframework.stereotype.Service;

@Service
public class RedTapeAirlinesUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }

        return new RedTapeAirlinesUserDetails(user);
    }
}

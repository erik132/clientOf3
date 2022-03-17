package erik.soekov.clientOf3.security.service;

import erik.soekov.clientOf3.security.dto.UserDTO;
import erik.soekov.clientOf3.security.exception.PasswordMismatchException;
import erik.soekov.clientOf3.security.exception.UsernameExistsException;
import erik.soekov.clientOf3.security.model.User;
import org.springframework.security.core.Authentication;

public interface RedTapeAirlinesUserService {

    public void registerUser(UserDTO userDTO) throws UsernameExistsException, PasswordMismatchException;
    public User findByUsername(String username);
    public User findByAuthentication(Authentication authentication);
}

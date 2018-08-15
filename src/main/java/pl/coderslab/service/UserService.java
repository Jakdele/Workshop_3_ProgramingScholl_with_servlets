package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.entity.User;


public class UserService {
    public static User hashPassword(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return user;
    }
}

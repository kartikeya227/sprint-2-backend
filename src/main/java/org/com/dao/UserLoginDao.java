package org.com.dao;

import org.com.model.UserLogin;
import org.com.model.users;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserLoginDao {
    public abstract Optional<users> userLogin(UserLogin userLogin);
}

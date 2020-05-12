package org.com.services;

import org.com.dao.UserLoginDao;
import org.com.dao.UserLoginRepository;
import org.com.dao.UserRepository;
import org.com.model.UserLogin;
import org.com.model.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginService implements UserLoginDao {

    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Optional<users> userLogin(UserLogin userLogin) {
        List<users> users = userRepository.findAll();
        int id = -1;
        for (int i = 0; i < users.size(); i++) {
            users user = users.get(i);
            if (user.getUserName().equals(userLogin.getUserName()) && user.getUserPassword().equals(userLogin.getPassword()))
                id = user.getUserId();
        }
        return userRepository.findById(id);
    }
}

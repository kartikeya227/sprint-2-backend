package org.com.services;

import org.com.dao.UserRepository;
import org.com.dao.UsersDao;
import org.com.model.scheduledFlight;
import org.com.model.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UsersDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(users user) {
        userRepository.save(user);
    }

    @Override
    public Optional<users> viewUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<users> viewAllUser() {
        return userRepository.findAll();
    }


    @Override
    public void updateUser(users user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }


}

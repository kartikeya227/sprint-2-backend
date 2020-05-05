package org.com.dao;

import org.com.model.users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersDao{
    public abstract void addUser(users user);
    public abstract Optional<users> viewUserById(int userId);
    public abstract List<users> viewAllUser();
    public abstract void updateUser(users user);
    public abstract void deleteUser(int userId);
}

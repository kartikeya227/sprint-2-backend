package org.com.dao;

import org.com.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserLoginRepository")
public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
}


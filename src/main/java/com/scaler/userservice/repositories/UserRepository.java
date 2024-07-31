package com.scaler.userservice.repositories;

import com.scaler.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReopsitory extends JpaRepository<User,Long> {


    User save(User user);
}

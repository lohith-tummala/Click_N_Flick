package com.clicknflick.Repository;

import com.clicknflick.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);

    User findByMobile(String mobile);
}


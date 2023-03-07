package com.cms.contactmanagementsystem.repository;

import com.cms.contactmanagementsystem.entities.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmailIdIgnoreCase(String emailId);

    Users findByUserName(String userName);
    Users findById(long userId);

    Users findByUserNameIgnoreCase(String userName);


}


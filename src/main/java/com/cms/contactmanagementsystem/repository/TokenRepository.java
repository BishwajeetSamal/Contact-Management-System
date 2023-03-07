package com.cms.contactmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.contactmanagementsystem.entities.users.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByUserId(long id);
    Token findByUserToken(String token);
    void delete(Token onj);
}


package com.cms.contactmanagementsystem.repository;

import com.cms.contactmanagementsystem.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String seachKey1, String seachKey2, String seachKey3);
}

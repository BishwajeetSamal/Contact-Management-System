package com.cms.contactmanagementsystem.controller;

import com.cms.contactmanagementsystem.entities.Contact;
import com.cms.contactmanagementsystem.repository.ContactRepository;
import com.cms.contactmanagementsystem.response.RestResponse;
import com.cms.contactmanagementsystem.response.StatusResponse;
import com.cms.contactmanagementsystem.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/contacts")
public class ContactController{

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public List<Contact> getAllContacts() {
        return contactService.fetchAllContacts();
    }

    @GetMapping("/{id}")
    public RestResponse getContactById(@PathVariable(value = "id") Long contactId)  {
        try {
            return contactService.getContactDetailById(contactId);
        }catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }
    }

    @PostMapping("/")
    public RestResponse createContact(@Valid @RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/{id}")
    public RestResponse updateContact(@Valid @RequestBody Contact contactDetails, HttpServletRequest req) {
        try {
            long userId = Long.parseLong(req.getAttribute("id").toString());
           return contactService.updateContactDetail(contactDetails,userId);
        }catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable Long contactId) {
        contactService.deleteContactById(contactId);
        return ResponseEntity.ok("Contact deleted successfully");
    }

    @GetMapping("/searchContact")
    public RestResponse SearchContact(@RequestParam String searchItem){
       try {
           return contactService.searchContactDetail(searchItem);
       }catch (Exception e) {
           return new StatusResponse(500, e.getMessage(), null);
       }
    }
}


package com.cms.contactmanagementsystem.service;

import com.cms.contactmanagementsystem.entities.Contact;
import com.cms.contactmanagementsystem.entities.users.Users;
import com.cms.contactmanagementsystem.repository.ContactRepository;
import com.cms.contactmanagementsystem.repository.UserRepository;
import com.cms.contactmanagementsystem.response.RestResponse;
import com.cms.contactmanagementsystem.response.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public RestResponse createContact(Contact contactData) {
            return new StatusResponse(200,"All Data",contactRepository.save(contactData));
    }

    @Override
    public void updateContact(Contact updateContact) {
        contactRepository.save(updateContact);
    }

    @Override
    public List<Contact> fetchAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public RestResponse getContactDetailById(Long contactId) throws NoSuchElementException {
        Optional<Contact> optionalContact=  contactRepository.findById(contactId);
        if(optionalContact.isPresent()){
            Contact contact = optionalContact.get();
            return new StatusResponse(200,"Contact Details",contact);
        }

        return  new StatusResponse(404,"Contact Details Not Available",null);
    }

    @Override
    public RestResponse updateContactDetail(Contact contactDetails,Long userId) {
        try {
            Contact contact = new Contact();
            contact.setFirstName(contactDetails.getFirstName());
            contact.setLastName(contactDetails.getLastName());
            contact.setEmail(contactDetails.getEmail());
            contact.setPhone_number(contactDetails.getPhone_number());
            Optional<Users> u = userRepository.findById(userId);
            if(u.isPresent()){
                Users user = u.get();
                contact.setUser(user);
            }
            Contact obj = contactRepository.save(contact);
            return new StatusResponse(200, "Contact Updated Successfully !", obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public RestResponse deleteContactById(Long contactId){
        try {
            contactRepository.deleteById(contactId);
          return new StatusResponse(200,"Contact Deleted Succsessfully",true);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public RestResponse searchContactDetail(String searchKey) {
        List<Contact> contact=contactRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(searchKey,searchKey,searchKey);
        return new StatusResponse(200,"All Search List",contact);
    }
}

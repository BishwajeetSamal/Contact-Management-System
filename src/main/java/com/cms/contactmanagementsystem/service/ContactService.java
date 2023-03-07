package com.cms.contactmanagementsystem.service;

import com.cms.contactmanagementsystem.entities.Contact;
import com.cms.contactmanagementsystem.response.RestResponse;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    public RestResponse createContact(Contact contactData);
    public void updateContact(Contact contactData);

    public List<Contact> fetchAllContacts();

    public RestResponse getContactDetailById(Long contactId);

    public  RestResponse updateContactDetail(Contact contactDetails,Long id);

    public RestResponse deleteContactById(Long contactId);

    public RestResponse searchContactDetail(String searchKey);
}

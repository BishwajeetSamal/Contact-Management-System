package com.cms.contactmanagementsystem.service;

import com.cms.contactmanagementsystem.dto.LoginDto;
import com.cms.contactmanagementsystem.dto.RegisterDto;
import com.cms.contactmanagementsystem.response.RestResponse;
import util.AlreadyExistException;
import util.HandleUserException;

public interface UserService {
    public RestResponse register(RegisterDto registerDto) throws AlreadyExistException;

    public RestResponse userLogin(LoginDto loginDto) throws HandleUserException;

    public RestResponse checkEmailExist(String emailId);

    public RestResponse checkUserNameExist(String userName);



}


package com.cms.contactmanagementsystem.controller;

import com.cms.contactmanagementsystem.dto.LoginDto;
import com.cms.contactmanagementsystem.dto.RegisterDto;
import com.cms.contactmanagementsystem.entities.users.Token;
import com.cms.contactmanagementsystem.repository.TokenRepository;
import com.cms.contactmanagementsystem.response.RestResponse;

import com.cms.contactmanagementsystem.response.StatusResponse;
import com.cms.contactmanagementsystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import util.AlreadyExistException;
import util.HandleUserException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TokenRepository tokenRespository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public RestResponse userRegister(@RequestBody RegisterDto registerDto) {
        try {
            return userService.register(registerDto);
        } catch (AlreadyExistException e) {
            logger.error(e.getMessage());
            return new StatusResponse(409, e.getMessage(), null);
        } catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }

    }

    //login code
    @PostMapping(value = "/login", produces = "application/json")
    public RestResponse userLogin(@RequestBody LoginDto loginDto) {
        try {
            return userService.userLogin(loginDto);
        } catch (HandleUserException e) {
            return new StatusResponse(404, e.getMessage(), null);
        } catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }
    }

    @GetMapping(value="/checkEmail/{emailId}")
    public RestResponse checkEmailExistOrNot(@PathVariable String emailId){
        try {
            return userService.checkEmailExist(emailId);
        }catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }
    }

    @GetMapping(value="/checkUserName/{userName}")
    public RestResponse checkUserNameExistOrNot(@PathVariable String userName){
        try {
            return userService.checkUserNameExist(userName);
        }catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }
    }

    //logout code
    @PostMapping(value = "/logout", produces = "application/json")
    public RestResponse logout(HttpServletRequest req) {
        try {
            Token tokenObj =  tokenRespository.findByUserToken(req.getHeader("Authorization"));
            tokenRespository.delete(tokenObj);
            return new StatusResponse(200,"Logout Successful",null);
        }catch (Exception e) {
            return new StatusResponse(500, e.getMessage(), null);
        }

    }

}

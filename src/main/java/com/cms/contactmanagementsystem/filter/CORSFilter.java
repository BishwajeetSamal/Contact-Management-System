package com.cms.contactmanagementsystem.filter;

import java.io.IOException;

import com.cms.contactmanagementsystem.entities.users.Users;
import com.cms.contactmanagementsystem.repository.UserRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class CORSFilter implements Filter {
    @Autowired
    UserRepository userRepository;
    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Authorization, type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addIntHeader("Access-Control-Max-Age", 180);
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) req;
            if (httpRequest.getHeader("Authorization") == null) {
                chain.doFilter(req, res);
            } else {

                String id = Jwts.parser().setSigningKey("SecretKeyToGenJWTs")
                        .parseClaimsJws(httpRequest.getHeader("Authorization")).getBody().getSubject();
                req.setAttribute("id", id);
                long userId = Long.parseLong(id);
                Users u = userRepository.findById(userId);
                if(u==null)
                {
                    throw new IOException("USER NOT FOUND");
                }
                chain.doFilter(req, res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}


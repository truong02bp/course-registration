package com.dangki.common.utils;

import com.dangki.data.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    public MyUserDetails getUserDetails()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (MyUserDetails) authentication.getPrincipal();
    }
}

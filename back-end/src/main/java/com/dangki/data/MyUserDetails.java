package com.dangki.data;


import com.dangki.data.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUserDetails extends User {
    private UserDto user;

    public MyUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                         Collection<? extends GrantedAuthority> authorities , UserDto user) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public UserDto getUser() {
        this.user.setPassword(null);
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}

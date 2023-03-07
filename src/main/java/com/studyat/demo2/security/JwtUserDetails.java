package com.studyat.demo2.security;

import com.studyat.demo2.entities.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
public class JwtUserDetails implements UserDetails {
    public Long id;
    private String UserName;
    private String Password;
    private Collection<? extends GrantedAuthority> authorities;

    private JwtUserDetails(Long id, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        UserName = userName;
        Password = password;
        this.authorities = authorities;
    }
    public static JwtUserDetails create(User user){
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("user"));
        return new JwtUserDetails(user.getId(), user.getUserName(), user.getPassword(), authorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

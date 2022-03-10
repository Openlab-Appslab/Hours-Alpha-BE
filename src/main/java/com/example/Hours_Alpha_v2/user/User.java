package com.example.Hours_Alpha_v2.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class User implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "generator_sequence",
            sequenceName = "generator_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "generator_sequence"
    )
    private Long id;

    @Column(
            name = "email",
            columnDefinition = "text",
            nullable = false
    )
    private String email;

    @Column(
            name = "first_name",
            columnDefinition = "text",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            columnDefinition = "text",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "telephone",
            columnDefinition = "long",
            nullable = false
    )
    private String telephone;

    @Enumerated
    @Column(
            name = "role",
            columnDefinition = "enum",
            nullable = false
    )
    private UserRoles userRoles;

    public User(String email, String firstName, String lastName, String telephone, UserRoles userRoles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.userRoles = userRoles;
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
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

package com.javacorner.admin.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String email;
    private String password;

    private Set<Role> roles = new HashSet<>();
    private Student student;
    private Instructor instructor;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void assignStudentToUser(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeStudentFromUser(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", email=" + email + ", password=" + password + "]";
    }

}

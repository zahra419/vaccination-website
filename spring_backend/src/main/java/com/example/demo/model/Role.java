package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name="role_id")
    private Long role_id;

    @Column(name = "role_name")
    private String role_name;

    // Constructors
    public Role() {}

    public Role(Long roleId, String role_name) {
        this.role_id = roleId;
        this.role_name = role_name;
    }

    // Getters and Setters
    public Long getRoleId() {
        return role_id;
    }

    public void setRoleId(Long role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return role_name;
    }

    public void setRoleName(String role_name) {
        this.role_name = role_name;
    }
}

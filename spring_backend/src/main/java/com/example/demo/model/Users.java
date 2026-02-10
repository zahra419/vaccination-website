package com.example.demo.model;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name="id")
    private Number id;
    @Column(name="full_name")
    private String full_name;
    @Column(name="cin")
    private String cin;
    @Column(name="password")   
    private String password;
    @Column(name="gender")
    private String gender;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "birth_date")
    private Date birth_date;
  

    public Users() {}

    public Users(Number id, String full_name, String cin, String password,String gender, Role role,Date birth_date) {
        this.id = id;
        this.full_name = full_name;
        this.cin = cin;
        this.password = password;
        this.role = role;
        this.gender=gender;
        this.role=role;
        this.birth_date=birth_date;
    }
    
    public void setFullName(String full_name){this.full_name=full_name;}
    public String getFullName(){return this.full_name;}
    public void setCin(String cin){this.cin=cin;}
    public String getCin(){return this.cin;}
    public void setPassword(String password){this.password=password;}
    public String getPassword(){return this.password;}
    public void setBirthDate(Date birth_date){this.birth_date=birth_date;}
    public Date getBirthDate(){return this.birth_date;}
    public void setRole(Role role){this.role=role;}
    public Role getRole(){return this.role;}
    public void setGender(String gender){this.gender=gender;}
    public String setGender(){return this.gender;}
}

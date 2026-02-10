package com.example.demo.dto;

public class LoginDto {
     private String full_name;
    private String role_name;
    private String cin;
    private String password;


    public LoginDto(String cin, String password,String role_name,String full_name) {
        this.password = password;
        this.role_name = role_name;
        this.cin=cin;
        this.full_name=full_name;
    }


   
    public void setPassword(String password) { 
        this.password = password; 
    }
    public String getPassword(){ return this.password;}
    public String getCin(){return this.cin;}
    public void setCin(String cin){this.cin=cin;}
    public void setRoleName(String role_name){this.role_name=role_name;}
    public String getRoleName() { return this.role_name; }
    public String getFullName(){return this.full_name;}
    public void setFullName(String full_name){this.full_name=full_name;}
   
}

package com.example.demo;

public class LoginResponse {

    private String token;
    private String cin;
    private String role;
    private String fullName;

  
    public LoginResponse() {}
    public LoginResponse(String token){
        this.token=token;
    }

    public LoginResponse(String token, String cin, String role,String fullName) {
        this.token = token;
        this.cin = cin;
        this.role = role;
        this.fullName=fullName;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public String getFullName(){
        return this.fullName;
    }
}

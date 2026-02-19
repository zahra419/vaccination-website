package com.example.demo; // adjust package to your project structure

public class LoginRequest {

    private String cin;
    private String password;
    private String fullName;

    //  Default constructor (required for @RequestBody deserialization)
    public LoginRequest() {}

    //  Constructor with parameters (optional)
    public LoginRequest(String cin, String password,String fullName) {
        this.cin = cin;
        this.password = password;
        this.fullName=fullName;
    }

    // Getters and Setters
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public String getFullName(){
        return fullName;
    }
}

package com.example.demo; // adjust package to your project structure

public class LoginRequest {

    private String cin;
    private String password;
    private String full_name;

    //  Default constructor (required for @RequestBody deserialization)
    public LoginRequest() {}

    //  Constructor with parameters (optional)
    public LoginRequest(String cin, String password,String full_name) {
        this.cin = cin;
        this.password = password;
        this.full_name=full_name;
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
    public void setFullName(String full_name){
        this.full_name=full_name;
    }
    public String getFullName(){
        return full_name;
    }
}

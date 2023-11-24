package tests.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginModel {
    public LoginModel(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    private String userName, password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

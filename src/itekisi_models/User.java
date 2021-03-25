package itekisi_models;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Date;

public class User {
    public String Id;
    public String Username;
    public String Password;

    HttpSession httpSession;
    HttpServletRequest request;

     String setSession(){
        httpSession = request.getSession();
        httpSession.setAttribute("username",getUsername());
        return httpSession.getId();
    }

    Date getCreationTime(){
         return new Date(httpSession.getCreationTime());
    }

    Date getLastAccessedTime(){
         return new Date(httpSession.getLastAccessedTime());
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

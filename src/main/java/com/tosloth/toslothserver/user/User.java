package com.tosloth.toslothserver.user;

import com.tosloth.toslothserver.goal.Goal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;

@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String nickname;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    private ArrayList<Goal> goalsArrayList = new ArrayList<>();

    public User() {}

    public User(String nickname, String password, String firstname, String lastname, String email) {
        this.nickname = nickname;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(String text, String hashPassword) {
        nickname = text;
        password = hashPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Goal> getGoalsArrayList() {
        return goalsArrayList;
    }

    public void setGoalsArrayList(ArrayList<Goal> goalsArrayList) {
        this.goalsArrayList = goalsArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User employee = (User) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.nickname, employee.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nickname);
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
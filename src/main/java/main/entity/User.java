package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "Users")
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public void setTime_result(Timestamp time_result) {
        this.time_result = time_result;
    }

    public void setInstance_id(Long instance_id) {
        this.instance_id = instance_id;
    }

    public User(Long id, String name, String surname, Double money, Timestamp time_result, Long instance_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.time_result = time_result;
        this.instance_id = instance_id;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "money")
    private Double money;

    public Long getId() {
        return id;
    }

    public Double getMoney() {
        return money;
    }

    public Timestamp getTimeResult() {
        return time_result;
    }

    public Long getInstanceId() {
        return instance_id;
    }

    @Column(name = "time_result")
    private Timestamp time_result;

    @Column(name = "instance_id")
    private Long instance_id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "active")
    private Boolean active;

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getTime_result() {
        return time_result;
    }

    public Long getInstance_id() {
        return instance_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public User() {}

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, name, surname);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

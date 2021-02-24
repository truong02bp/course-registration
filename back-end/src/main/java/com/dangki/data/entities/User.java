package com.dangki.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users" , uniqueConstraints ={ @UniqueConstraint(columnNames = "username")
                                            ,@UniqueConstraint(columnNames = "code") })
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "email")
    private String email;
    @Column(name = "lop")
    private String lop;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "major")
    private String major;
    @Column(name = "birthday")
    private String birthday;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @ManyToMany(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @JoinTable(name = "user_class_room",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "class_room_id"))
    private List<ClassRoom> classRooms;
    @ManyToMany(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = @JoinColumn(name = "user_id")
                , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "avatar_url")
    private String url;

    @Column(name = "name_honey")
    private String nameHoney;

    public String getNameHoney() {
        return nameHoney;
    }

    public void setNameHoney(String nameHoney) {
        this.nameHoney = nameHoney;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(List<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

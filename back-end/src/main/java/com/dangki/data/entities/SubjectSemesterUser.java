package com.dangki.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A SubjectSemesterUser.
 */
@Entity
@Table(name = "subject_semester_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SubjectSemesterUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "subjectSemesterUsers", allowSetters = true)
    private User user;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "subjectSemesterUsers", allowSetters = true)
    private Semester semester;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "subjectSemesterUsers", allowSetters = true)
    private Subject subject;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActive() {
        return active;
    }

    public SubjectSemesterUser active(Boolean active) {
        this.active = active;
        return this;
    }
    public Subject getSubject() {
        return subject;
    }

    public SubjectSemesterUser subject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public SubjectSemesterUser user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Semester getSemester() {
        return semester;
    }

    public SubjectSemesterUser semester(Semester semester) {
        this.semester = semester;
        return this;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubjectSemesterUser)) {
            return false;
        }
        return id != null && id.equals(((SubjectSemesterUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SubjectSemesterUser{" +
            "id=" + getId() +
            ", active='" + isActive() + "'" +
            "}";
    }
}

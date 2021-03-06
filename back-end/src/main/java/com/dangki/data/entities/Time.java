package com.dangki.data.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Time.
 */
@Entity
@Table(name = "times")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Time extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lesson")
    private Integer lesson;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Time name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLesson() {
        return lesson;
    }

    public Time lesson(Integer lesson) {
        this.lesson = lesson;
        return this;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Time)) {
            return false;
        }
        return id != null && id.equals(((Time) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Time{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", lesson=" + getLesson() +
            "}";
    }
}

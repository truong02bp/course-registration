package com.dangki.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Details.
 */
@Entity
@Table(name = "details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Details extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "details", allowSetters = true)
    private Time time;

    @ManyToOne(cascade = CascadeType.ALL , optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "details", allowSetters = true)
    private Professor professor;

    @ManyToOne(cascade = CascadeType.ALL , optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "details", allowSetters = true)
    private Room room;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @NotNull
    @JoinTable(name = "details_week",
               joinColumns = @JoinColumn(name = "details_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "week_id", referencedColumnName = "id"))
    private Set<Week> weeks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public Details time(Time time) {
        this.time = time;
        return this;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Details professor(Professor professor) {
        this.professor = professor;
        return this;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Room getRoom() {
        return room;
    }

    public Details room(Room room) {
        this.room = room;
        return this;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<Week> getWeeks() {
        return weeks;
    }

    public Details weeks(Set<Week> weeks) {
        this.weeks = weeks;
        return this;
    }

    public Details addWeek(Week week) {
        this.weeks.add(week);
        return this;
    }

    public Details removeWeek(Week week) {
        this.weeks.remove(week);
        return this;
    }

    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Details)) {
            return false;
        }
        return id != null && id.equals(((Details) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

}

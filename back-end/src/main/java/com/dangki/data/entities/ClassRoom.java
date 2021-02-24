package com.dangki.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class_room")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ClassRoom extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nmh", nullable = false)
    private String nmh;

    @Column(name = "tth")
    private Integer tth;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "slot")
    private Integer slot;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "classRooms", allowSetters = true)
    private Subject subject;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @NotNull
    @JoinTable(name = "class_room_details",
            joinColumns = @JoinColumn(name = "class_room_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "details_id", referencedColumnName = "id"))
    private Set<Details> details = new HashSet<>();


    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmh() {
        return nmh;
    }

    public void setNmh(String nmh) {
        this.nmh = nmh;
    }

    public Integer getTth() {
        return tth;
    }

    public ClassRoom tth(Integer tth) {
        this.tth = tth;
        return this;
    }

    public void setTth(Integer tth) {
        this.tth = tth;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ClassRoom quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSlot() {
        return slot;
    }

    public ClassRoom slot(Integer slot) {
        this.slot = slot;
        return this;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Subject getSubject() {
        return subject;
    }

    public ClassRoom subject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Details> getDetails() {
        return details;
    }

    public ClassRoom details(Set<Details> details) {
        this.details = details;
        return this;
    }

    public ClassRoom addDetails(Details details) {
        this.details.add(details);
        return this;
    }

    public ClassRoom removeDetails(Details details) {
        this.details.remove(details);
        return this;
    }

    public void setDetails(Set<Details> details) {
        this.details = details;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassRoom)) {
            return false;
        }
        return id != null && id.equals(((ClassRoom) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + getId() +
                ", nhm=" + getNmh() +
                ", tth=" + getTth() +
                ", quantity=" + getQuantity() +
                ", slot=" + getSlot() +
                "}";
    }
}
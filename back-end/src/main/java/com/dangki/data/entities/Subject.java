package com.dangki.data.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A Subject.
 */
@Entity
@Table(name = "subject")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Subject extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "fee")
    private Integer fee;

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

    public Subject name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Subject code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCredit() {
        return credit;
    }

    public Subject credit(Integer credit) {
        this.credit = credit;
        return this;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getFee() {
        return fee;
    }

    public Subject fee(Integer fee) {
        this.fee = fee;
        return this;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subject)) {
            return false;
        }
        return id != null && id.equals(((Subject) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Subject{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", credit=" + getCredit() +
            ", fee=" + getFee() +
            "}";
    }
}

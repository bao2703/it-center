package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onAdd() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericEntity)) return false;

        GenericEntity that = (GenericEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getCreatedAt().equals(that.getCreatedAt())) return false;
        if (!getUpdatedAt().equals(that.getUpdatedAt())) return false;
        return getDeletedAt().equals(that.getDeletedAt());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + getUpdatedAt().hashCode();
        result = 31 * result + getDeletedAt().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GenericEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deleteAt=" + deletedAt +
                '}';
    }
}

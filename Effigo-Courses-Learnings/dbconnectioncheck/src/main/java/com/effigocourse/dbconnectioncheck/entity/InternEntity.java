package com.effigocourse.dbconnectioncheck.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "intern_details")
public class InternEntity {
    @Id //annotation to add primary key for an entity
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String role;
}

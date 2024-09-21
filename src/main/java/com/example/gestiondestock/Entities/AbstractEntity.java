package com.example.gestiondestock.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    @CreatedDate
    @Column(name = "creationDate",nullable = false)
    @JsonIgnore
    private Instant creationDate;
    @LastModifiedDate
    @Column(name = "lastModifiedDate",nullable = false)
     @JsonIgnore
    private Instant lastModifiedDate;

}

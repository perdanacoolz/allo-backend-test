package com.allobank.allobackendtest.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "partai")
@Data
public class Partai {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "namaPartai", nullable = false)
    private String namaPartai;
    @Column(name = "nomorUrut", nullable = false)
    private Integer nomorUrut;
}

//test
package com.allobank.allobackendtest.model;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dapil")
@Data
public class Dapil {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
    @Column(name = "namaDapil", nullable = false)
    private String namaDapil;
    @Column(name = "provinsi", nullable = false)
    private String provinsi;
    private List<String> wilayahDapilList;
    @Id
    @Column(name = "jumlahKursi", nullable = false)
    private int jumlahKursi;
}
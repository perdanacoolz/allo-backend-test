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
@Table(name = "caleg")
 
@Data
public class Caleg {
     @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
    //private Dapil dapil;
    private Partai partai;
    private Integer nomorUrut;
    @Column(name = "namaDapil", nullable = false)
    private String nama;
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;
}

package com.allobank.allobackendtest.model;

//import javax.persistence.*; // for Spring Boot 2
import jakarta.persistence.*;

@Entity
@Table(name = "caleg")
public class Caleg {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="id", insertable = false, updatable = false)
    private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dapil_id")
    private Dapil dapil;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partai_id")
    private Partai partai;
    @Column(name = "nomorUrut")
    private Integer nomorUrut;
    @Column(name = "nama")
    private String nama;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jenkel_id")
    private JenisKelamin jenisKelamin;

 

  public Caleg() {

  }

  public Caleg(String nama,  Integer nomorUrut) {
    this.nama = nama;
    this.nomorUrut = nomorUrut;
    
  }

  public long getId() {
    return id;
  }

  public String getnama() {
    return nama;
  }

  public void setnama(String nama) {
    this.nama = nama;
  }
   

  public Integer getnomorUrut() {
    return nomorUrut;
  }

  public void setnomorUrut(Integer nomorUrut) {
    this.nomorUrut = nomorUrut ;
  }

 
  @Override
  public String toString() {
    return "Partai [id=" + id + ", nama=" + nama + ", nomorUrut=" + nomorUrut +"]";
  }

}

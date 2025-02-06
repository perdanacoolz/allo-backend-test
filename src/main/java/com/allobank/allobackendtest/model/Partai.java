package com.allobank.allobackendtest.model;

//import javax.persistence.*; // for Spring Boot 2
import jakarta.persistence.*;

@Entity
@Table(name = "partai")
public class Partai {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long partai_id;

  @Column(name = "namaPartai")
  private String namaPartai;

  @Column(name = "nomorUrut")
  private Integer nomorUrut;

 

  public Partai() {

  }

  public Partai(String namaPartai, Integer nomorUrut) {
    this.namaPartai = namaPartai;
    this.nomorUrut = nomorUrut;
    
  }

  public long getpartai_id() {
    return partai_id;
  }

  public String getnamaPartai() {
    return namaPartai;
  }

  public void setnamaPartai(String namaPartai) {
    this.namaPartai = namaPartai;
  }

  public Integer getnomorUrut() {
    return nomorUrut;
  }

  public void setnomorUrut(Integer nomorUrut) {
    this.nomorUrut = nomorUrut;
  }

 
  @Override
  public String toString() {
    return "Partai [partai_id=" + partai_id + ", namaPartai=" + namaPartai + ", nomorUrut=" + nomorUrut + "]";
  }

}

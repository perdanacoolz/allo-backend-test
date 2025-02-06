package com.allobank.allobackendtest.model;

//import javax.persistence.*; // for Spring Boot 2
import jakarta.persistence.*;

@Entity
@Table(name = "dapil")
public class Dapil {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long dapil_id;

  @Column(name = "namaDapil")
  private String namaDapil;

  @Column(name = "provinsi")
  private String provinsi;
  
  @Column(name = "jumlahKursi")
  private Integer jumlahKursi;

 

  public Dapil() {

  }

  public Dapil(String namaDapil,String provinsi,  Integer jumlahKursi) {
    this.namaDapil = namaDapil;
    this.provinsi = provinsi;
    
  }

  public long getdapil_id() {
    return dapil_id;
  }

  public String getnamaDapil() {
    return namaDapil;
  }

  public void setnamaDapil(String namaDapil) {
    this.namaDapil = namaDapil;
  }
  
  public String getprovinsi() {
	    return provinsi;
	  }

	  public void setprovinsi(String provinsi) {
	    this.provinsi = provinsi;
	  }

  public Integer getjumlahKursi() {
    return jumlahKursi;
  }

  public void setjumlahKursi(Integer jumlahKursi) {
    this.jumlahKursi = jumlahKursi;
  }

 
  @Override
  public String toString() {
    return "Partai [dapil_id=" + dapil_id + ", namaDapil=" + namaDapil + ", provinsi=" + provinsi + ",jumlahKursi="+jumlahKursi+"]";
  }

}

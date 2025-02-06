package com.allobank.allobackendtest.model;

//import javax.persistence.*; // for Spring Boot 2
import jakarta.persistence.*;

@Entity
@Table(name = "JenisKelamin")
public class JenisKelamin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jenkel_id;
    private String nama;

    @Enumerated(EnumType.STRING) // Store the enum as a string in the database
    private Status status;

  public JenisKelamin() {

  }

  public JenisKelamin(String nama) {
    this.nama = nama;
     
    
  }

  public long getjenkel_id() {
    return jenkel_id;
  }

  public String getnama() {
    return nama;
  }

  public void setnama(String nama) {
    this.nama = nama;
  }
  
  
  public enum Status {
	  LAKILAKI, PEREMPUAN
	}
  @Override
  public String toString() {
    return "Partai [jenkel_id=" + jenkel_id + ", nama=" + nama + "]";
  }

}



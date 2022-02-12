package ktp.ktp.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_penduduk")
public class Penduduk {

    @Id
    @Column(length = 50, nullable = false, unique = true)
    private String nik;

    @Column(length = 100, nullable = false)
    private String nama;

    @Column(length = 150, nullable = false)
    private String tempat_lahir;

    @Column(length = 100, nullable = false)
    private String tgl_lahir;

    @Column(length = 100, nullable = false)
    private String alamat;

    @Column(length = 100, nullable = false)
    private String propinsi;

    @Column(length = 150, nullable = false)
    private String kabupaten;

    @Column(length = 100, nullable = false)
    private String kecamatan;

    @Column(length = 100, nullable = false)
    private String kelurahan;

    @Column(length = 100, nullable = false)
    private String jkelamin;

    @Column(length = 100, nullable = false)
    private String agama;





}

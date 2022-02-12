package ktp.ktp.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@Table(name = "tbl_ktp")
public class Ktp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private Integer samid;

    @Column(length = 50, nullable = false)
    private String rdid;

    @Column(length = 100, nullable = false)
    private String model;

    @Column(length = 50, nullable = true, unique = true)
    private String nik;

    @Column(length = 100, nullable = true)
    private String nama;

    @Column(length = 150, nullable = true)
    private String tempat_lahir;

    @Column(length = 100, nullable = true)
    private String tgl_lahir;

    @Column(length = 100, nullable = true)
    private String alamat;

    @Column(length = 100, nullable = true)
    private String propinsi;

    @Column(length = 150, nullable = true)
    private String kabupaten;

    @Column(length = 100, nullable = true)
    private String kecamatan;

    @Column(length = 100, nullable = true)
    private String kelurahan;

    @Column(length = 100, nullable = true)
    private String jkelamin;

    @Column(length = 100, nullable = true)
    private String agama;

    @Column(length = 100, nullable = false)
    private String rcode;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    @Temporal (TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

}

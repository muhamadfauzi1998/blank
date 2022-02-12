package ktp.ktp.models.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@NoArgsConstructor
@Table(name = "tbl_kartu")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIgnoreProperties(value = {"create_at"}, allowGetters = true)
public class Kartu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private Integer samid;

    @Column(length = 50, nullable = false)
    private String rdid;

    @Column(length = 100, nullable = false)
    private String model;

    @OneToOne
//    @JoinTable(
//            name = "tbl_kartu_penduduk",
//            joinColumns = @JoinColumn (name = "kartu_id"),
//            inverseJoinColumns = @JoinColumn(name = "penduduk_id")
//    )
    //@JsonManagedReference
    private Penduduk report;

    @Column(length = 100, nullable = false)
    private String rcode;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
//    @Column(nullable = false, updatable = false)
    @Temporal (TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;


}

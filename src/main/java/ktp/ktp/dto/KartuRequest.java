package ktp.ktp.dto;

import ktp.ktp.models.entities.Penduduk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Data

public class KartuRequest {
    private Integer samid;
    private String rdid;
    private String model;
    private Penduduk report;
    private String rcode;
    private Date create_at;


}

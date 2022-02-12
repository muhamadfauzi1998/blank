package ktp.ktp.dto;

import ktp.ktp.models.entities.Penduduk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
public class KartuResponse {
    private Long id;
    private Integer samid;
    private String rdid;
    private String model;
    private Penduduk report;
    private String rcode;
    private Date created_at;
}

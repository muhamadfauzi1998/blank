package ktp.ktp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class KartuData {

    private long id;
    private Integer samid;
    private String rdid;
    private String model;
    private PendudukData report;
    private String rcode;
    private Date created_at;
}

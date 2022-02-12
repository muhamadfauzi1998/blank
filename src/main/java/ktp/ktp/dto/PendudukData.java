package ktp.ktp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class PendudukData {

    private String nik;
    private String nama;
    private String tempat_lahir;
    private String tgl_lahir;
    private String alamat;
    private String propinsi;
    private String kabupaten;
    private String kecamatan;
    private String kelurahan;
    private String jkelamin;
    private String agama;
}

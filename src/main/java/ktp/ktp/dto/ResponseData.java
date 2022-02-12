package ktp.ktp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseData <T>{
    private boolean status;
    private List<String> messages = new ArrayList<>();
//    private List<KartuDataResponse> lsKartu= new ArrayList<>();
    private T payload;
}

package ktp.ktp.controllers;

import ktp.ktp.dto.KartuRequest;
import ktp.ktp.dto.KartuResponse;
import ktp.ktp.dto.ResponseData;
import ktp.ktp.models.entities.Kartu;
import ktp.ktp.services.KartuService;
import ktp.ktp.utility.ErrorParshingUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("kartu")
public class KartuController {

    @Autowired
    private KartuService kartuService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    public ResponseEntity<ResponseData<KartuResponse>> save(@Valid @RequestBody KartuRequest kartuRequest, Errors errors){
        ResponseData<KartuResponse> responseData = new ResponseData<>();

        if (errors.hasErrors()){
            responseData.setStatus(false);
            responseData.setMessages(ErrorParshingUtility.parse(errors));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }try {
            Kartu kartu = modelMapper.map(kartuRequest, Kartu.class);
            kartu = kartuService.save(kartu);
            responseData.setStatus(true);
            responseData.getMessages().add("Data Tersimpan");
            responseData.setPayload(modelMapper.map(kartu, KartuResponse.class));
            return ResponseEntity.ok(responseData);
        }catch (Exception e){
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @GetMapping("/getAll")
    public Iterable<Kartu> findAll(){
        return kartuService.findAll();
    }
}

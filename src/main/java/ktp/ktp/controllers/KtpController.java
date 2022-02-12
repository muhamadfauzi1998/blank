package ktp.ktp.controllers;

import ktp.ktp.dto.*;
import ktp.ktp.models.entities.Kartu;
import ktp.ktp.models.entities.Ktp;
import ktp.ktp.services.KartuService;
import ktp.ktp.services.KtpService;
import ktp.ktp.utility.ErrorParshingUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ktp")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @Autowired
    private KartuService kartuService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/save")
    public ResponseEntity<Ktp> save(@Valid @RequestBody KartuData kartuData, Errors errors){
        ResponseData<KartuDataResponse> responseData = new ResponseData<>();

        if (errors.hasErrors()){
            responseData.setStatus(false);
            responseData.setMessages(ErrorParshingUtility.parse(errors));
            return new ResponseEntity<Ktp>(HttpStatus.BAD_REQUEST);
        }try {
            Ktp ktp = modelMapper.map(kartuData, Ktp.class);
            ktp = ktpService.save(ktp);
            responseData.setStatus(true);

            responseData.getMessages().add("Data Tersimpan");
            responseData.setPayload(modelMapper.map(ktp, KartuDataResponse.class));
            return new ResponseEntity<Ktp>(HttpStatus.CREATED);
        }catch (Exception e){
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            return new ResponseEntity<Ktp>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

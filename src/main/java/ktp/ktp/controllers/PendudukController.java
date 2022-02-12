package ktp.ktp.controllers;

import ktp.ktp.dto.PendudukRequest;
import ktp.ktp.dto.PendudukResponse;
import ktp.ktp.dto.ResponseData;
import ktp.ktp.models.entities.Kartu;
import ktp.ktp.models.entities.Penduduk;
import ktp.ktp.services.PendudukService;
import ktp.ktp.utility.ErrorParshingUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/penduduk")
public class PendudukController {
    @Autowired
    private PendudukService pendudukService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    public ResponseEntity<ResponseData<PendudukResponse>> save(@Valid @RequestBody PendudukRequest pendudukRequest, Errors errors){
        ResponseData<PendudukResponse> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            responseData.setStatus(false);
            responseData.setMessages(ErrorParshingUtility.parse(errors));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }try {
            Penduduk penduduk = modelMapper.map(pendudukRequest, Penduduk.class);
            penduduk = pendudukService.save(penduduk);
            responseData.setStatus(true);
            responseData.getMessages().add("Penduduk saved");
            responseData.setPayload(modelMapper.map(penduduk, PendudukResponse.class));
            return ResponseEntity.ok(responseData);
        }catch (Exception e){
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @GetMapping("/getAll")
    public Iterable<Penduduk> findAll(){
        return pendudukService.findAll();
    }
}

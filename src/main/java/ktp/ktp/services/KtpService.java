package ktp.ktp.services;

import ktp.ktp.dto.KartuData;
import ktp.ktp.models.entities.Ktp;
import ktp.ktp.models.repos.KtpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class KtpService {

    @Autowired
    private KtpRepo ktpRepo;

    public Ktp save(Ktp kartuData){
//        Ktp ktp = new Ktp();
//        ktp.setId(kartuData.getId());
//        ktp.setAgama(kartuData.getReport().getAgama());
//        ktp.setAlamat(kartuData.getReport().getAlamat());
//        ktp.setJkelamin(kartuData.getReport().getJkelamin());
//        ktp.setNik(kartuData.getReport().getNik());
//        ktp.setNama(kartuData.getReport().getNama());
//        ktp.setKecamatan(kartuData.getReport().getKecamatan());
//        ktp.setKelurahan(kartuData.getReport().getKelurahan());
//        ktp.setKabupaten(kartuData.getReport().getKabupaten());
//        ktp.setPropinsi(kartuData.getReport().getPropinsi());
//        ktp.setTempat_lahir(kartuData.getReport().getTempat_lahir());
//        ktp.setTgl_lahir(kartuData.getReport().getTgl_lahir());
//        ktp.setRdid(kartuData.getRdid());
//        ktp.setSamid(kartuData.getSamid());
//        ktp.setModel(kartuData.getModel());
//        ktp.setRcode(kartuData.getRcode());
//        ktp.setCreated_at(new Date());

        return ktpRepo.save(kartuData);
    }
}

package ktp.ktp.services;

import ktp.ktp.models.entities.Kartu;
import ktp.ktp.models.repos.KartuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class KartuService {

    @Autowired
    private KartuRepo kartuRepo;

    public Kartu save(Kartu kartu){
        return kartuRepo.save(kartu);
    }

    public Iterable<Kartu> findAll(){
        return kartuRepo.findAll();
    }

}

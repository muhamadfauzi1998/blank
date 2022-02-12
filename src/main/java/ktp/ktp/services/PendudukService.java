package ktp.ktp.services;

import ktp.ktp.models.entities.Penduduk;
import ktp.ktp.models.repos.PendudukRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PendudukService {

    @Autowired
    private PendudukRepo pendudukRepo;

    public Penduduk save(Penduduk penduduk){
        return pendudukRepo.save(penduduk);
    }

    public Iterable<Penduduk> findAll(){
        return pendudukRepo.findAll();
    }
}

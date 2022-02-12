package ktp.ktp.models.repos;

import ktp.ktp.models.entities.Penduduk;
import org.springframework.data.repository.CrudRepository;

public interface PendudukRepo extends CrudRepository<Penduduk, String> {
}

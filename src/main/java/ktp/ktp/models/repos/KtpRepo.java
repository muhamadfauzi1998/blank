package ktp.ktp.models.repos;

import ktp.ktp.models.entities.Ktp;
import org.springframework.data.repository.CrudRepository;

public interface KtpRepo extends CrudRepository<Ktp, Long> {
}

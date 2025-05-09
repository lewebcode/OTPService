package fun.justdevelops.otpservice.model.repo;

import fun.justdevelops.otpservice.model.entity.OtpConfig;
import org.springframework.data.repository.CrudRepository;

public interface OtpConfigRepo extends CrudRepository<OtpConfig, Integer> {
}

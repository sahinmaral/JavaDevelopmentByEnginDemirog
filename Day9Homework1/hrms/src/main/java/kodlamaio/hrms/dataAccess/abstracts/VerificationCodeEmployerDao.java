package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeEmployerDao extends JpaRepository<VerificationCodeEmployer, Integer> {
}

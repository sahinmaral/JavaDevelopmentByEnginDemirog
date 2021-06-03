package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateForeignLanguageDao extends JpaRepository<CandidateForeignLanguage,Integer> {
}

package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CvDao extends JpaRepository<Cv,Integer> {
    Cv findById(int id);
    boolean existsById(int id);
}

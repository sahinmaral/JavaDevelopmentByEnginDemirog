package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingTechnologyDao extends JpaRepository<kodlamaio.hrms.entities.concretes.ProgrammingTechnology,Integer> {
}

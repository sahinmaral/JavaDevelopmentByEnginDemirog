package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}

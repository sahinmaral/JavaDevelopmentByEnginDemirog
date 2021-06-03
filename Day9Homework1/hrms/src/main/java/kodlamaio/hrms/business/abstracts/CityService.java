package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService extends BaseService<City>{
    Result add(City city);
}

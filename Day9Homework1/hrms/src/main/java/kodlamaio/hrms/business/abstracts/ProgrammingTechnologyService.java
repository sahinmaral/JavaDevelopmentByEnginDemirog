package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;

import java.util.List;

public interface ProgrammingTechnologyService {
    Result add(ProgrammingTechnology programmingTechnology);
    DataResult<ProgrammingTechnology> getById(int id);
    DataResult<List<ProgrammingTechnology>> getAll();
}

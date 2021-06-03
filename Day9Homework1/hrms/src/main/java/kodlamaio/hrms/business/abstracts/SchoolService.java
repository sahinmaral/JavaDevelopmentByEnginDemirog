package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;

import java.util.List;

public interface SchoolService {
    Result add(School school);
    Result addOneByOne(List<School> schools, Cv cv);
    DataResult<List<SchoolDto>> getAllByCandidateId(int candidateId);
}

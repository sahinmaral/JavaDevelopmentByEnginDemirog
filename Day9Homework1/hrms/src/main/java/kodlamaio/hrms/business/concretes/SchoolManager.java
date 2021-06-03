package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    private SchoolDao schoolDao;
    
    @Override
    public Result add(School school) {
        var schools = schoolDao.findAll();
        schoolDao.save(school);
        return new SuccessResult();
    }

    @Override
    public Result addOneByOne(List<School> schools, Cv cv) {
        for (var item : schools){
            item.setCv(cv);
            schoolDao.save(item);
        }

        return new SuccessResult();
    }

    @Override
    public DataResult<List<SchoolDto>> getAllByCandidateId(int candidateId) {

        var result = schoolDao.getAllByCandidateId(candidateId);

        for(var item : result){
            if (item.getGraduatedDate() == null)
                item.setStatus("Devam ediyor");
            else
                item.setStatus("Mezun oldu");
        }

            return new SuccessDataResult<>(result);
    }
}

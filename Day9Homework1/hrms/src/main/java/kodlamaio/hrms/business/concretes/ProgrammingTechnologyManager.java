package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ProgrammingTechnologyService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingTechnologyDao;
import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

    @Autowired
    public ProgrammingTechnologyManager(ProgrammingTechnologyDao programmingTechnologyDao) {
        this.programmingTechnologyDao = programmingTechnologyDao;
    }

    private ProgrammingTechnologyDao programmingTechnologyDao;


    @Override
    public Result add(ProgrammingTechnology programmingTechnology) {
        var programmingTechnologys = programmingTechnologyDao.findAll();
        programmingTechnologyDao.save(programmingTechnology);
        return new SuccessResult();
    }

    @Override
    public DataResult<ProgrammingTechnology> getById(int id) {
        return new SuccessDataResult<>
                (programmingTechnologyDao.getOne(id));
    }

    @Override
    public DataResult<List<ProgrammingTechnology>> getAll() {
        return new SuccessDataResult<>
                (programmingTechnologyDao.findAll());
    }


}

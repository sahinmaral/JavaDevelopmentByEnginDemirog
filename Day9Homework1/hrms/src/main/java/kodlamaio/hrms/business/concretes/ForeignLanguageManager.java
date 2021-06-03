package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    private ForeignLanguageDao foreignLanguageDao;


    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        var foreignLanguages = foreignLanguageDao.findAll();
        foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult();
    }

    @Override
    public DataResult<ForeignLanguage> getById(int id) {
        return new SuccessDataResult<>
                (foreignLanguageDao.getOne(id));
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<>
                (foreignLanguageDao.findAll());
    }

}

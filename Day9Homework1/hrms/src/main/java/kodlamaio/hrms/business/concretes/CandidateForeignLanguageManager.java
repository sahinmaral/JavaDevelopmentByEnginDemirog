package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateForeignLanguageService;
import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.business.abstracts.ProgrammingTechnologyService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateForeignLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateForeignLanguage;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateForeignLanguageManager implements CandidateForeignLanguageService {

    @Autowired
    public CandidateForeignLanguageManager
            (
                    CandidateForeignLanguageDao candidateForeignLanguageDao,
                    ForeignLanguageService foreignLanguageService
            )
    {
        this.candidateForeignLanguageDao = candidateForeignLanguageDao;
        this.foreignLanguageService = foreignLanguageService;
    }

    private final ForeignLanguageService foreignLanguageService;
    private final CandidateForeignLanguageDao candidateForeignLanguageDao;

    @Override
    public Result add(CandidateForeignLanguage candidateForeignLanguage) {
        candidateForeignLanguageDao.save(candidateForeignLanguage);
        return new SuccessResult();
    }

    @Override
    public Result addOneByOne(List<CandidateForeignLanguage> candidateForeignLanguages, Cv cv) {
        for (var item : candidateForeignLanguages){
            item.setCv(cv);

            var candidateForeignLanguage =
                    foreignLanguageService.getById
                            (item.getForeignLanguage().getId());

            item.setForeignLanguage(candidateForeignLanguage.getData());

            add(item);
        }

        return new SuccessResult();
    }
}

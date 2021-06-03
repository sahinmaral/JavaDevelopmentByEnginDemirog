package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CandidateForeignLanguage;
import kodlamaio.hrms.entities.concretes.Cv;

import java.util.List;

public interface CandidateForeignLanguageService {
    Result add(CandidateForeignLanguage CandidateForeignLanguage);
    Result addOneByOne(List<CandidateForeignLanguage> candidateForeignLanguages, Cv cv);
}

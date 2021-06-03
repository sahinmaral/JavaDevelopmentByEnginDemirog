package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    Result add(ForeignLanguage foreignLanguage);
    DataResult<ForeignLanguage> getById(int id);
    DataResult<List<ForeignLanguage>> getAll();
}

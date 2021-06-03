package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import org.springframework.beans.factory.annotation.Autowired;

public class CityValidator implements BaseValidator{

    @Autowired
    public CityValidator(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    private CityDao cityDao;

    public Result isCityExist(int cityId){
        if (cityDao.findById(cityId).equals(null))
            return new SuccessResult();
        return new ErrorResult(Messages.CityDoesntExist);
    }
}

package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.core.entities.Employer;

public class EmployerValidator extends UserValidator {

    private EmployerDao employerDao;

    public EmployerValidator(EmployerDao employerDao, UserDao userDao) {
        super(userDao);
        this.employerDao = employerDao;
    }


    public Result isEmployerExist(int employerId){
        var employers = employerDao.findAll();
        for(var employer : employers){
            if (employer.getId()==employerId)
                return new SuccessResult();
        }

        return new ErrorResult(Messages.EmployerDoesntExist);
    }

}

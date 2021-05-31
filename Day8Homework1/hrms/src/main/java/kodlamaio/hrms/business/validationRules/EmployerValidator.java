package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator extends UserValidator {

    private EmployerDao employerDao;

    public EmployerValidator(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }


    public Result areAllInformationFilledOnRegister(Employer employer) {
        if
        (
                        employer.getPhoneNumber().equals("") ||
                        employer.getEmail().equals("") ||
                        employer.getWebSite().equals("") ||
                        employer.getCompanyName().equals("") ||
                        employer.getPassword().equals("") ||
                        employer.getPasswordRepeat().equals("")
        ) {
            return new ErrorResult(Messages.FieldsNull);
        }
        return new SuccessResult();


    }
    public Result isEmailTaken(String email) {
        var employers = employerDao.findAll();
        for (var employer : employers) {
            if (employer.getEmail().equals(email))
                return new ErrorResult(Messages.EmailAlreadyTaken);
        }
        return new SuccessResult();
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

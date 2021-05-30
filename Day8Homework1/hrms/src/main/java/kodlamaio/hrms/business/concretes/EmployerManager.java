package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCandidateService;
import kodlamaio.hrms.business.abstracts.VerificationEmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private VerificationEmployerService verificationEmployerService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, VerificationEmployerService verificationEmployerService) {
        this.employerDao = employerDao;
        this.verificationEmployerService = verificationEmployerService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public Result register(Employer entity) {
        EmployerValidator validator = new EmployerValidator(employerDao);
        Result[] validators = new Result[]{
                validator.areAllInformationFilledOnRegister(entity),
                validator.isEmailTaken(entity.getEmail()),
                validator.arePasswordsSame(entity.getPassword(), entity.getPasswordRepeat()),
                validator.isEmailValid(entity.getEmail())
        };

        for (var item : validators) {
            if (!item.isSuccess())
                return new ErrorResult(item.getMessage());
        }

        employerDao.save(entity);

        verificationEmployerService.sendVerificationCode(entity.getId(),entity.getEmail());
        return new SuccessResult(Messages.SuccessfullyRegistered);
    }

    @Override
    public Result verifyAccountByVerificationCode(String email,String code){

        var entities = getAll().getData();
        Employer employer = null;

        for (var item : entities) {
            if (item.getEmail().equals(email)){
                employer = item;
                var result = verificationEmployerService.verifyAccount(employer.getId(),code);
                if (!result.isSuccess())
                    return result;
            }
        }



        return new SuccessResult(Messages.EmailVerificationDone);

    }


}

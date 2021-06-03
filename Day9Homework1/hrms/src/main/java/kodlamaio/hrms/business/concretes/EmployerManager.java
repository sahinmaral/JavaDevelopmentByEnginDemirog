package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationEmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.core.entities.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserDao userDao;
    private VerificationEmployerService verificationEmployerService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,
                           VerificationEmployerService verificationEmployerService,
                           UserDao userDao) {
        this.userDao = userDao;
        this.employerDao = employerDao;
        this.verificationEmployerService = verificationEmployerService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public Result register(Employer entity) {
        EmployerValidator validator = new EmployerValidator(employerDao,userDao);
        Result[] validators = new Result[]{
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

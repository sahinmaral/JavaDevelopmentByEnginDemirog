package kodlamaio.hrms.business.validationRules;


import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidateValidator extends UserValidator {


    private CandidateDao candidateDao;
    private UserDao userDao;

    @Autowired
    public CandidateValidator(CandidateDao candidateDao,UserDao userDao) {
        this.candidateDao = candidateDao;
        this.userDao = userDao;
    }

    public Result areAllInformationFilledOnRegister(Candidate candidate) {
        if
        (
                candidate.getIdentityId().equals("") ||
                        candidate.getBirthYear() == 0 ||
                        candidate.getEmail().equals("") ||
                        candidate.getFirstName().equals("") ||
                        candidate.getLastName().equals("") ||
                        candidate.getIdentityId().equals("")
        ) {
            return new ErrorResult(Messages.FieldsNull);
        }
        return new SuccessResult();


    }
    public Result isEmailTaken(String email) {
        var candidates = userDao.findAll();
        for (var candidate : candidates) {
            if (candidate.getEmail().equals(email))
                return new ErrorResult(Messages.EmailAlreadyTaken);
        }
        return new SuccessResult();
    }
    public Result isIdentityIdTaken(String identityId){
        var candidates = candidateDao.findAll();
        for (var candidate : candidates) {
            if (candidate.getIdentityId().equals(identityId))
                return new ErrorResult(Messages.IdentityIdAlreadyTaken);
        }
        return new SuccessResult();
    }



}

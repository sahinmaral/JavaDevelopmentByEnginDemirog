package kodlamaio.hrms.business.validationRules;


import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.core.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidateValidator extends UserValidator {


    private CandidateDao candidateDao;

    @Autowired
    public CandidateValidator(CandidateDao candidateDao,UserDao userDao) {
        super(userDao);
        this.candidateDao = candidateDao;
    }

    public Result isIdentityIdTaken(String identityId){
        if (candidateDao.existsCandidateByIdentityId(identityId))
            return new ErrorResult(Messages.IdentityIdAlreadyTaken);
        return new SuccessResult();
    }



}

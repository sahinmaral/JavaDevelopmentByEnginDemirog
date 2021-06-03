package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCandidateService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.core.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.core.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private UserDao userDao;
    private VerificationCandidateService verificationCandidateService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao,
                            VerificationCandidateService
                                    verificationCandidateService,UserDao userDao) {
        this.verificationCandidateService = verificationCandidateService;
        this.candidateDao = candidateDao;
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll());
    }

    @Override
    public Result register(Candidate entity) {

        CandidateValidator validator = new CandidateValidator(candidateDao,userDao);
        Result[] validators = new Result[]{
                //validator.areAllInformationFilledOnRegister(entity),
                validator.isEmailTaken(entity.getEmail()),
                validator.arePasswordsSame(entity.getPassword(), entity.getPasswordRepeat()),
                validator.isIdentityIdTaken(entity.getIdentityId()),
                validator.isEmailValid(entity.getEmail())
        };

        for (var item : validators) {
            if (!item.isSuccess())
                return new ErrorResult(item.getMessage());
        }

        AuthenticationService authenticationService =
                new AuthenticationManager(new MernisServiceAdapter());

        if (!authenticationService.checkIfRealPerson(
                entity.getIdentityId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthYear()
                ).isSuccess()
        ){
            return new ErrorResult(Messages.PersonIsInvalid);
        }

        candidateDao.save(entity);

        verificationCandidateService.sendVerificationCode(entity.getId(),entity.getEmail());

        return new SuccessResult(Messages.SuccessfullyRegistered+entity.getEmail()+" adresinize gelecek olan onay kodu ile hesabınızı onaylayınız.");
    }

    @Override
    public Result verifyAccountByVerificationCode(String email,String code){

        var entities = getAll().getData();
        Candidate candidate = null;

        for (var item : entities) {
            if (item.getEmail().equals(email))
                candidate = item;
        }

        var result = verificationCandidateService.verifyAccount(candidate.getId(),code);
        if (!result.isSuccess())
            return result;

        return new SuccessResult(Messages.EmailVerificationDone);

    }


}

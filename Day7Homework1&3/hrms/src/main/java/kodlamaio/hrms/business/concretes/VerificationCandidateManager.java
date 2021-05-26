package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationCandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationCandidateManager implements
        VerificationCandidateService {

    private VerificationCodeCandidateService verificationCodeCandidateService;


    @Autowired
    public VerificationCandidateManager(VerificationCodeCandidateService verificationCodeCandidateService) {
        this.verificationCodeCandidateService = verificationCodeCandidateService;
    }


    @Override
    public Result sendVerificationCode(int entityId, String email) {
        verificationCodeCandidateService.sendVerificationCode(entityId,email);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<VerificationCodeCandidate>> getAll() {
        return new SuccessDataResult<>
                (verificationCodeCandidateService.getAll().getData());
    }

    @Override
    public Result verifyAccount(int entityId, String code) {
        int verificationCodeId = 0;
        var results = getAll().getData();
        for (var result : results)
        {
            if (entityId==result.getCandidateId() && code.equals(result.getCode())) {
                verificationCodeId = result.getId();
                verificationCodeCandidateService.verifyAccount(verificationCodeId, entityId, code);
                return new SuccessResult();
            }
        }

        return new ErrorResult(Messages.WrongVerificationCode);
    }
}

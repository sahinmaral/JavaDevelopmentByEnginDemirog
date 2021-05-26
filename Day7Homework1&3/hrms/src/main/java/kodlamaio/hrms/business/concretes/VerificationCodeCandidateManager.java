package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.MailVerificationService;
import kodlamaio.hrms.business.abstracts.VerificationCandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.adapters.HotmailVerificationAdapter;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeCandidateDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService {

    private VerificationCodeCandidateDao entityDao;


    @Autowired
    public VerificationCodeCandidateManager(VerificationCodeCandidateDao entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public DataResult<List<VerificationCodeCandidate>> getAll() {
        return new SuccessDataResult<>(entityDao.findAll());
    }

    @Override
    public Result verifyAccount(int verificationCodeId,int entityId, String code) {
        var verificationCodes = getAll().getData();
        VerificationCodeCandidate verificationCode = null;
        for (var item : verificationCodes){
            if (item.getId()==verificationCodeId)
                verificationCode = item;
        }

        verificationCode.setVerified(true);
        entityDao.save(verificationCode);

        return new ErrorResult();

    }

    @Override
    public Result sendVerificationCode(int entityId, String email) {
        MailVerificationService service = new HotmailVerificationAdapter();
        var code = service.sendVerificationCode(email);

        VerificationCodeCandidate verificationCode = new VerificationCodeCandidate();
        verificationCode.setCode(code);
        verificationCode.setCandidateId(entityId);
        verificationCode.setVerifiedDate(LocalDateTime.now());

        entityDao.save(verificationCode);
        return new SuccessResult();
    }





}

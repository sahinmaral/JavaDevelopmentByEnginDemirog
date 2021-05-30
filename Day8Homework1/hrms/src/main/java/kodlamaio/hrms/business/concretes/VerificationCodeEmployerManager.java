package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.MailVerificationService;
import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.adapters.HotmailVerificationAdapter;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeEmployerDao;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService {

    private VerificationCodeEmployerDao entityDao;


    @Autowired
    public VerificationCodeEmployerManager(VerificationCodeEmployerDao entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public DataResult<List<VerificationCodeEmployer>> getAll() {
        return new SuccessDataResult<>(entityDao.findAll());
    }

    @Override
    public Result verifyAccount(int verificationCodeId,int entityId, String code) {
        var verificationCodes = getAll().getData();
        VerificationCodeEmployer verificationCode = null;
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

        VerificationCodeEmployer verificationCode = new VerificationCodeEmployer();
        verificationCode.setCode(code);
        verificationCode.setEmployerId(entityId);
        verificationCode.setVerifiedDate(LocalDateTime.now());

        entityDao.save(verificationCode);
        return new SuccessResult();
    }





}

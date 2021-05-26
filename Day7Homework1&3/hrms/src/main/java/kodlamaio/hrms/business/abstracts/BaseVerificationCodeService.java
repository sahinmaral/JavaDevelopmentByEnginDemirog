package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;

import java.util.List;

public interface BaseVerificationCodeService<T> {
    Result sendVerificationCode(int entityId, String email);
    DataResult<List<T>> getAll();
    Result verifyAccount(int verificationCodeId,int entityId,String code);
}

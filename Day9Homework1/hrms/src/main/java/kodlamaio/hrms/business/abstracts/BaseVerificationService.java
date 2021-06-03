package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

import java.util.List;

public interface BaseVerificationService<T> {
    Result sendVerificationCode(int entityId, String email);
    DataResult<List<T>> getAll();
    Result verifyAccount(int entityId,String code);
}

package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;


public interface UserService<T> extends BaseService<T> {

    Result register(T entity);

}

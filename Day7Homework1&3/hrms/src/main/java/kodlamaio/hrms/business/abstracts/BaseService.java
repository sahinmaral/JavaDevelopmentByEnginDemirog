package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.result.DataResult;

import java.util.List;

public interface BaseService<T> {
    DataResult<List<T>> getAll();
}

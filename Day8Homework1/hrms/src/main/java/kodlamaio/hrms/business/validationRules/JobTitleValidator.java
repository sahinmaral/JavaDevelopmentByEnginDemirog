package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

public class JobTitleValidator implements BaseValidator {

    public Result isTitleFilled(String title){
        if (title.equals(""))
            return new ErrorResult(Messages.FieldsNull);

        return new SuccessResult();
    }

}

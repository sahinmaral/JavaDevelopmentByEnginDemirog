package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;


public class AuthenticationManager implements AuthenticationService {

    private PersonCheckService personCheckService;

    @Autowired
    public AuthenticationManager(PersonCheckService personCheckService) {
        this.personCheckService = personCheckService;
    }

    public Result checkIfRealPerson(String identityId, String firstName, String lastName, int birthYear ){

        if (!personCheckService.checkIfRealPerson
                (identityId, firstName, lastName, birthYear)
        )
            return new ErrorResult(Messages.PersonIsInvalid);

        return new SuccessResult();
    }


}

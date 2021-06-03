package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.dataAccess.abstracts.UserDao;

public class EmployeeValidator extends UserValidator {


    public EmployeeValidator(UserDao userDao) {
        super(userDao);
    }
}

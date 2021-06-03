package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import org.springframework.beans.factory.annotation.Autowired;


public class JobAdvertValidator implements BaseValidator{

    @Autowired
    public JobAdvertValidator(JobAdvertDao jobAdvertDao) {
        this.jobAdvertDao = jobAdvertDao;
    }

    private JobAdvertDao jobAdvertDao;


    public Result getAdvertIsActive(int jobAdvertId){

        if (!jobAdvertDao.findById(jobAdvertId).getActive())
        return new ErrorResult(Messages.JobAdvertAlreadyDisabled);

        return new SuccessResult();
    }

    public Result isAdvertExist(int jobAdvertId){
        if (jobAdvertDao.existsById(jobAdvertId))
            return new SuccessResult();
        return new ErrorResult(Messages.JobAdvertDoesntExist);
    }

    public Result getAdvertIsPassive(int jobAdvertId) {

        if (jobAdvertDao.findById(jobAdvertId).getActive())
        return new ErrorResult(Messages.JobAdvertAlreadyEnabled);

        return new SuccessResult();
    }

    /*public Result checkPublishDateAndDeadline(LocalDate publishDate , LocalDate deadline){
        int publishDateMonth = publishDate.getMonth().getValue();
        int deadlineMonth = deadline.getMonth().getValue();

        int publishDateDay = publishDate.getDayOfMonth();
        int deadlineDay = deadline.getDayOfMonth();

        if (publishDateMonth==deadlineMonth || publishDateDay-deadlineDay<0)
            return new ErrorResult(Messages.PublishDateDayIsLessThanDeadlineDay);

    }*/

}

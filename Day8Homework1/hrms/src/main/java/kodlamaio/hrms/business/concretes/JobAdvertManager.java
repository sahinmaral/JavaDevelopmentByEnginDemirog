package kodlamaio.hrms.business.concretes;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.CityValidator;
import kodlamaio.hrms.business.validationRules.EmployerValidator;
import kodlamaio.hrms.business.validationRules.JobAdvertValidator;
import kodlamaio.hrms.business.validationRules.JobPositionValidator;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao,
                            CityDao cityDao,
                            JobPositionDao jobPositionDao,
                            EmployerDao employerDao) {
        this.jobAdvertDao = jobAdvertDao;
        this.cityDao = cityDao;
        this.jobPositionDao = jobPositionDao;
        this.employerDao=employerDao;
    }
    private CityDao cityDao;
    private JobPositionDao jobPositionDao;
    private JobAdvertDao jobAdvertDao;
    private EmployerDao employerDao;

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findAll(), Messages.SuccessfullyRetrieved);
    }


    @Override
    public Result add(JobAdvert jobAdvert) {

        JobAdvertValidator advertValidator = new JobAdvertValidator(jobAdvertDao);
        CityValidator cityValidator = new CityValidator(cityDao);
        JobPositionValidator jobPositionValidator = new JobPositionValidator(jobPositionDao);
        EmployerValidator employerValidator = new EmployerValidator(employerDao);

        Result[] validators = new Result[]{
                advertValidator.areAllInformationFilled(jobAdvert),
                cityValidator.isCityExist(jobAdvert.getCities().getId()),
                jobPositionValidator.isJobPositionExist(jobAdvert.getJobPositions().getId()),
                employerValidator.isEmployerExist(jobAdvert.getEmployers().getId())
        };

        for (var validator : validators){
            if (!validator.isSuccess())
                return new ErrorResult(validator.getMessage());
        }

        jobAdvertDao.save(jobAdvert);
        return new SuccessResult(Messages.SuccessfullyAdded);
    }

    @Override
    public Result disableById(int jobAdvertId) {

        JobAdvertValidator validator = new JobAdvertValidator(jobAdvertDao);
        Result[] validators = new Result[]{
                validator.isAdvertExist(jobAdvertId),
                validator.getAdvertIsActive(jobAdvertId)
        };

        for (var item : validators) {
            if (!item.isSuccess())
                return new ErrorResult(item.getMessage());
        }

        JobAdvert foundAdvert = jobAdvertDao.findById(jobAdvertId);
        foundAdvert.setActive(false);
        jobAdvertDao.save(foundAdvert);
        return new SuccessResult(Messages.JobAdvertDisabled);
    }

    @Override
    public Result enableById(int jobAdvertId) {
        JobAdvertValidator validator = new JobAdvertValidator(jobAdvertDao);
        Result[] validators = new Result[]{
                validator.isAdvertExist(jobAdvertId),
                validator.getAdvertIsPassive(jobAdvertId)
        };

        for (var item : validators) {
            if (!item.isSuccess())
                return new ErrorResult(item.getMessage());
        }

        JobAdvert foundAdvert = jobAdvertDao.findById(jobAdvertId);
        foundAdvert.setActive(true);
        jobAdvertDao.save(foundAdvert);
        return new SuccessResult(Messages.JobAdvertEnabled);
    }

    @Override
    public DataResult<List<JobAdvert>> getActivatedAdverts() {
        return null;
    }

    @Override
    public DataResult<JobAdvert> getById(int jobAdvertId) {
        return new SuccessDataResult<JobAdvert>(jobAdvertDao.getById(jobAdvertId));
    }


    @Override
    public DataResult<List<JobAdvertDto>> getAllPassiveAdsByDetails() {
        return new SuccessDataResult<List<JobAdvertDto>>
                (jobAdvertDao.getAllPassiveAdsByDetails(), Messages.SuccessfullyRetrieved);
    }

    @Override
    public DataResult<List<JobAdvertDto>> getAllActiveAdsByDeadline(LocalDate deadline) {
        return new SuccessDataResult<List<JobAdvertDto>>
                (jobAdvertDao.getAllActiveAdsByDeadlineIs(deadline), Messages.SuccessfullyRetrieved);
    }

    @Override
    public DataResult<List<JobAdvertDto>> getAllActiveAdsByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertDto>>
                (jobAdvertDao.getAllActiveAdsByEmployerId(employerId), Messages.SuccessfullyRetrieved);
    }

    @Override
    public DataResult<List<JobAdvertDto>> getAllAdsByDetails() {
        return new SuccessDataResult<List<JobAdvertDto>>
                (jobAdvertDao.getAllAdsByDetails(), Messages.SuccessfullyRetrieved);
    }
}

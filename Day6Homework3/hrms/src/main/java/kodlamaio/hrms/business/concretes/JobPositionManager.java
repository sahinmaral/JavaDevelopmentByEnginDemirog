package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobTitleService {

    private JobTitleDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobTitleDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return this.jobPositionDao.findAll();
    }
}

package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CvManager implements CvService {

    @Autowired
    public CvManager(CvDao cvDao,
                                  ImageUploadService imageUploadService,
                                  CandidateKnowledgeService candidateKnowledgeService,
                                  SchoolService schoolService,
                                  JobHistoryService jobHistoryService,
                                  CandidateForeignLanguageService candidateForeignLanguageService,
                                  ImageDao imageDao
                                 )
    {
        this.cvDao = cvDao;
        this.imageDao = imageDao;
        this.candidateKnowledgeService = candidateKnowledgeService;
        this.imageUploadService = imageUploadService;
        this.schoolService = schoolService;
        this.jobHistoryService = jobHistoryService;
        this.candidateForeignLanguageService = candidateForeignLanguageService;
    }

    private final CandidateKnowledgeService candidateKnowledgeService;
    private final SchoolService schoolService;
    private final JobHistoryService jobHistoryService;
    private final ImageUploadService imageUploadService;
    private final CvDao cvDao;
    private final ImageDao imageDao;
    private final CandidateForeignLanguageService candidateForeignLanguageService;

    @Override
    public Result add(Cv cv) {

        cvDao.save(cv);

        candidateKnowledgeService.addOneByOne
                (cv.getCandidateKnowledges(),cv);

        schoolService.addOneByOne
                (cv.getSchools(),cv);

        jobHistoryService.addOneByOne
                (cv.getJobHistories(),cv);

        candidateForeignLanguageService.addOneByOne
                (cv.getCandidateForeignLanguages(),cv);

        return new SuccessResult(Messages.SuccessfullyAdded);
    }


    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<>
                (cvDao.findAll(),Messages.SuccessfullyRetrieved);
    }

    @Override
    public Result uploadImage(int cvId , MultipartFile multipartFile) {

        if(cvDao.existsById(cvId)){

            var imageMap = imageUploadService.uploadPicture(multipartFile).getData();

            var imageUrl = imageMap.get("url").toString();
            var publicImageId = imageMap.get("public_id").toString();

            Image image = new Image();
            image.setPublicImageId(publicImageId);
            image.setUrl(imageUrl);

            imageDao.save(image);

            var cv = findById(cvId).getData();
            cv.setImage(image);

            cvDao.save(cv);

            return new SuccessResult(Messages.SuccessfullyAdded);
        }

        return new ErrorResult(Messages.CvDoesntExisted);

    }

    @Override
    public DataResult<Cv> findById(int id) {
        return new SuccessDataResult<>(cvDao.findById(id));
    }



}

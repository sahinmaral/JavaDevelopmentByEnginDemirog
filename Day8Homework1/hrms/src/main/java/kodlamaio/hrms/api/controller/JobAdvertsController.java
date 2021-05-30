package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/jobadverts")
@RestController
public class JobAdvertsController {
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    private JobAdvertService jobAdvertService;

    @GetMapping("/getall")
    public DataResult<List<JobAdvert>> getAll(){
        return new SuccessDataResult<List<JobAdvert>>(jobAdvertService.getAll().getData());
    }


    @PostMapping("/add")
    public Result add(@RequestParam(name="advert_id") int advertId,
                      @RequestParam(name="advert_id") short maxSalary,
                      @RequestParam(name="advert_id") short minSalary,
                      @RequestParam(name="advert_id") String city,
                      @RequestParam(name="advert_id") LocalDate deadline,
                      @RequestParam(name="advert_id") short countOfReceivableCandidate,
                      @RequestParam(name="advert_id") String jobRequirements,
                      @RequestParam(name="advert_id") int jobPositionId,
                      @RequestParam(name="is_active") boolean isActive){

        jobAdvertService.add(advertId);
        return new SuccessResult();
    }

}

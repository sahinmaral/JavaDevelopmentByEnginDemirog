package kodlamaio.hrms.api.controller;

import io.swagger.annotations.ApiParam;
import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.format.annotation.DateTimeFormat;
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
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<List<JobAdvert>>(jobAdvertService.getAll().getData());
    }

    @GetMapping("/getalladsbydetails")
    public DataResult<List<JobAdvertDto>> getAllAdsByDetails() {
        return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertService.getAllAdsByDetails().getData());
    }

    @GetMapping("/getallpassiveadsbydetails")
    public DataResult<List<JobAdvertDto>> getAllPassiveAdsByDetails() {
        return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertService.getAllPassiveAdsByDetails().getData());
    }

    @GetMapping("/getallactiveadsbydeadline")
    public DataResult<List<JobAdvertDto>> getAllActiveAdsByDeadline
            (@RequestParam(name="deadline")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     LocalDate deadline)
    {
        return new SuccessDataResult<List<JobAdvertDto>>
                (jobAdvertService.getAllActiveAdsByDeadline(deadline).getData());
    }

    @GetMapping("/getallactiveadsbyemployerid")
    public DataResult<List<JobAdvertDto>> getAllActiveAdsByEmployerId(@RequestParam int employerId)
    {
        return new SuccessDataResult<List<JobAdvertDto>>
                (jobAdvertService.getAllActiveAdsByEmployerId(employerId).getData());
    }

    @PostMapping("/disableById")
    public Result disableById(@RequestParam int jobAdvertId) {
    return jobAdvertService.disableById(jobAdvertId);
    }

    @PostMapping("/enablebleById")
    public Result enablebleById(@RequestParam int jobAdvertId) {
        return jobAdvertService.enableById(jobAdvertId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert) {
       return jobAdvertService.add(jobAdvert);
    }

}

package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitlesController {

    private JobTitleService jobPositionService;

    @Autowired
    public JobTitlesController(JobTitleService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }


    @GetMapping("/getAll")
    public List<JobTitle> getAll(){
        return jobPositionService.getAll();
    }
}

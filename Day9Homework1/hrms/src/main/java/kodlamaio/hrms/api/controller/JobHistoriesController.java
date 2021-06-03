package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobHistoryService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobHistories")
public class JobHistoriesController {

    @Autowired
    public JobHistoriesController(JobHistoryService jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    private JobHistoryService jobHistoryService;

    @GetMapping("/getAllByCandidateId")
    public Result getAllByCandidateId(int candidateId){
        return jobHistoryService.getAllByCandidateId(candidateId);
    }

}

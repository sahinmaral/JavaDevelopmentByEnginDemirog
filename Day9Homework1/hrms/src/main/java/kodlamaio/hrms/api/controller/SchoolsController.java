package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    private SchoolService schoolService;

    @GetMapping("/getAllByCandidateId")
    public Result getAllByCandidateId(int candidateId){
        return schoolService.getAllByCandidateId(candidateId);
    }

}

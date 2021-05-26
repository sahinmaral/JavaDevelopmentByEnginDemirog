package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.UserForVerifyVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll(){
        return candidateService.getAll();
    }

    @PostMapping("/register")
    public Result register(@RequestBody Candidate candidate){
        return candidateService.register(candidate);
    }

    @PostMapping("/verifyAccountByVerificatinCode")
    public Result verifyAccount(@RequestBody UserForVerifyVerificationCode user){
        return candidateService.verifyAccountByVerificationCode(user.getEmail(),user.getCode());
    }


}

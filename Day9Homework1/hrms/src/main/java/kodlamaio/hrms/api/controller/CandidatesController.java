package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.entities.Candidate;
import kodlamaio.hrms.entities.dtos.UserForVerifyVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> register(@Valid @RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.register(candidate));
    }

    @PostMapping("/verifyAccountByVerificatinCode")
    public Result verifyAccount(@RequestBody UserForVerifyVerificationCode user){
        return candidateService.verifyAccountByVerificationCode(user.getEmail(),user.getCode());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldErrror : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldErrror.getField(),fieldErrror.getDefaultMessage());
        }

        ErrorDataResult<Object> errors =
                new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");

        return errors;
    }



}

package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvController {

    @Autowired
    public CvController
            (
                    CvService cvService
            )
    {
        this.cvService = cvService;
    }

    private CvService cvService;

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv){

        var result = cvService.add(cv);
        if (!result.isSuccess()) return new ErrorResult(result.getMessage());

        return new SuccessResult(result.getMessage());
    }

    @GetMapping("/getAll")
    public DataResult<List<Cv>> getAll(){
        return new SuccessDataResult<List<Cv>>(cvService.getAll().getData());
    }

    @PostMapping("/uploadImage")
    public Result uploadImage(@RequestParam int cvId , @RequestParam MultipartFile multipartFile){
        return cvService.uploadImage(cvId , multipartFile);
    }
}

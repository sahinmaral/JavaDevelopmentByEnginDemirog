package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.lang.invoke.MutableCallSite;
import java.util.List;

public interface CvService {
    Result add(Cv cv);
    DataResult<List<Cv>> getAll();
    Result uploadImage(int cvId , MultipartFile multipartFile);
    DataResult<Cv> findById(int id);
}

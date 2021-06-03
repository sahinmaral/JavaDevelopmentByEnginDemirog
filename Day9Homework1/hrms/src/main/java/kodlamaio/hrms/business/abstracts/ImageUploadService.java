package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ImageUploadService {
    DataResult<Map> uploadPicture(MultipartFile multipartFile);
    Result deletePicture(String publicImageId);
}

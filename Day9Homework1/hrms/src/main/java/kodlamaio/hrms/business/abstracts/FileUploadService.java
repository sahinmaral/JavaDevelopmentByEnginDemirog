package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.result.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;


public interface FileUploadService {
    Map upload(MultipartFile multipartFile);
    Map delete(String publicImageId);
    DataResult<File> convert(MultipartFile multipartFile);
}

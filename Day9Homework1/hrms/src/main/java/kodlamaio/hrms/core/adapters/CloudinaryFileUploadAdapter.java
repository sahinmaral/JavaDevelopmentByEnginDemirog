package kodlamaio.hrms.core.adapters;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.business.abstracts.FileUploadService;
import kodlamaio.hrms.business.constants.CloudinaryConstants;
import kodlamaio.hrms.core.utilities.result.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;

@Service
public class CloudinaryFileUploadAdapter implements FileUploadService {

    CloudinaryConstants constant = new CloudinaryConstants();
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", constant.cloudName,
                "api_key", constant.apiKey,
                "api_secret", constant.apiSecret));

    @Override
    public Map upload(MultipartFile multipartFile){
        try{
            File file = convert(multipartFile).getData();
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return uploadResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map delete(String publicImageId){
        try
        {
            Map result = cloudinary.uploader().destroy(publicImageId,ObjectUtils.emptyMap());
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DataResult<File> convert(MultipartFile multipartFile) {

        try{
            File file = new File(multipartFile.getOriginalFilename());
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(multipartFile.getBytes());
            stream.close();
            return new SuccessDataResult<File>(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<File>("Error");

    }


}

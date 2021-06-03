package kodlamaio.hrms.business.abstracts;

public interface MailVerificationService {
    public String sendVerificationCode(String email);
}

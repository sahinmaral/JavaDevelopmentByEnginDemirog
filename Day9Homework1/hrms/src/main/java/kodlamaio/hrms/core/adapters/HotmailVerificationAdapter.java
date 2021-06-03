package kodlamaio.hrms.core.adapters;


import kodlamaio.hrms.business.abstracts.MailVerificationService;
import kodlamaio.hrms.mailVerification.HotmailVerificationService;

public class HotmailVerificationAdapter implements MailVerificationService {
    public String sendVerificationCode(String email){
        HotmailVerificationService service = new HotmailVerificationService();
        return service.sendVerificationCode(email);
    }
}

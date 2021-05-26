package kodlamaio.hrms.business.abstracts;

public interface PersonCheckService {
     boolean checkIfRealPerson(String identityId,String firstName,String lastName,int birthYear);
}

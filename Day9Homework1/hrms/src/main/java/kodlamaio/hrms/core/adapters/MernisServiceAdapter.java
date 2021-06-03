package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.mernisService.NVRKPSPublicSoap;

public class MernisServiceAdapter implements PersonCheckService {

    public boolean checkIfRealPerson(String identityId,String firstName,String lastName,int birthYear) {
        NVRKPSPublicSoap client = new NVRKPSPublicSoap();

        try{
            return client.TCKimlikNoDogrula(
                    Long.parseLong(identityId),
                    firstName.toUpperCase(),
                    lastName.toUpperCase(),
                    birthYear);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
}

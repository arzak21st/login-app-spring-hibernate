package dev.arzak21st.loginapp.services;

import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.repositories.GetRepository;
import dev.arzak21st.loginapp.utilities.ApplicationContextUtility;
import static dev.arzak21st.loginapp.utilities.ValidateUtility.validateParameters;

public class LoginService extends ApplicationContextUtility {

    GetRepository getRepository = (GetRepository) getApplicationContext().getBean("getRepository");

    public UserCredential loginUser(String email, String password) {

        UserCredential userCredential = null;

        Object[] parameters = {email, password};
        boolean parametersAreValid = validateParameters(parameters);

        if(parametersAreValid) {
            userCredential = getRepository.getUserCredentialByEmailAndPassword(email, password);
        }
        
        return userCredential;
    }
}

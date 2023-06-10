package com.tanvir.tanvirmahmudkhan.workingwithapi.connectivity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("SignUp/PatientSignUp")
    Call<String> postPatientSignUp (@Body String singUpUserId);
}

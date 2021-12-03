package com.bca.service.resources;

import com.bca.service.ErrorSchema;
import com.bca.service.models.BcaRequest;
import com.bca.service.models.BcaResponse;
import com.bca.service.models.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class BcaController
{
    @GetMapping("/bca/customer")
    public Response<BcaResponse> getCustomerData(@RequestBody BcaRequest bcaRequest){
        return new Response<BcaResponse>(new ErrorSchema(), BcaResponse.builder().identityNo("098765432123456").dateOfBirth(LocalDate.of(2021, 11, 11)).build());

    }
}

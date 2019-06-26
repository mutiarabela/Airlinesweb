package com.restapi.airlines.controller;

import com.restapi.airlines.exception.CompanyNotFoundException;
import com.restapi.airlines.exception.MembershipNotFoundException;
import com.restapi.airlines.model.request.CompanyRequestModel;
import com.restapi.airlines.model.request.MembershipRequestModel;
import com.restapi.airlines.model.response.CompanyResponseModel;
import com.restapi.airlines.model.response.MembershipResponseModel;
import com.restapi.airlines.service.CompanyService;
import com.restapi.airlines.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping(path = "/{cId}",
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getCompany(@PathVariable Integer cId){ //Get specific Company
        CompanyResponseModel getCompanyValue = companyService.getCompany(cId);
        if (getCompanyValue != null) {
            return new ResponseEntity<>(getCompanyValue, HttpStatus.OK);
        } else {
            throw new CompanyNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllCompany(){ //Get all added Company
        Collection getAllCompanyValue = companyService.getAllCompany();
        return new ResponseEntity<>(getAllCompanyValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createCompany(@Valid @RequestBody CompanyRequestModel companyRequest){ //Create Company
        CompanyResponseModel createCompanyValue = companyService.createCompany(companyRequest);
        return new ResponseEntity<>(createCompanyValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{cId}",
            consumes = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<CompanyResponseModel> updateCompany(@PathVariable Integer cId, @Valid @RequestBody CompanyRequestModel companyRequest){ //Update Membership's phone number
        CompanyResponseModel updateCompanyValue = companyService.updateCompany(cId, companyRequest);
        if (updateCompanyValue != null) {
            return new ResponseEntity<>(updateCompanyValue, HttpStatus.OK);
        } else {
            throw new CompanyNotFoundException("Update Failed, Company Not Found");
        }
    }

    @DeleteMapping(path = "/{cId}")
    public ResponseEntity deleteCompany(@PathVariable Integer cId){ //Delete Company
        CompanyResponseModel deleteCompanyValue = companyService.deleteCompany(cId);
        if (deleteCompanyValue != null) {
            return new ResponseEntity<>(deleteCompanyValue, HttpStatus.OK);
        } else {
            throw new CompanyNotFoundException("Delete Failed, Company Not Found");
        }
    }
}

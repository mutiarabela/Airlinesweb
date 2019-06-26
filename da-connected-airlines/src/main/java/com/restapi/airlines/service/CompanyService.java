package com.restapi.airlines.service;

import com.restapi.airlines.model.request.CompanyRequestModel;
import com.restapi.airlines.model.response.CompanyResponseModel;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class CompanyService {
    CompanyResponseModel addCompany;

    HashMap<Integer, CompanyResponseModel> company;

    public CompanyService(){ //Hardcode create Company
        CompanyResponseModel addFirstCompany = new CompanyResponseModel();

        addFirstCompany.setCId(1);
        Integer idFirstCompany = addFirstCompany.getCId();

        addFirstCompany.setCName("Nusa Satu Inti Artha PT");
        addFirstCompany.setCBalance(1000000000.00);

        if(company == null){
            company = new HashMap<>();
        }

        company.put(idFirstCompany, addFirstCompany);

        CompanyResponseModel addSecondCompany = new CompanyResponseModel();

        addSecondCompany.setCId(2);
        Integer idSecondCompany = addSecondCompany.getCId();

        addSecondCompany.setCName("Saroha CV");
        addSecondCompany.setCBalance(50000000.00);

        company.put(idSecondCompany, addSecondCompany);

        CompanyResponseModel addThirdCompany = new CompanyResponseModel();

        addThirdCompany.setCId(3);
        Integer idThirdCompany = addThirdCompany.getCId();

        addThirdCompany.setCName("Nine Ball PT");
        addThirdCompany.setCBalance(250000000.00);

        company.put(idThirdCompany, addThirdCompany);
    }

    public CompanyResponseModel createCompany(CompanyRequestModel companyRequest) { //Create Company by input
        addCompany = new CompanyResponseModel();

        addCompany.setCId(companyRequest.getCId());
        Integer cId = addCompany.getCId();

        addCompany.setCId(companyRequest.getCId());
        addCompany.setCName(companyRequest.getCName());
        addCompany.setCBalance(companyRequest.getCBalance());

        company.put(cId, addCompany);
        return addCompany;
    }

    public CompanyResponseModel getCompany (Integer cId) { //Get specific company to view
        return company.get(cId);
    }

    public Collection<CompanyResponseModel> getAllCompany() { //Get all added company
        return company.values();
    }

    public CompanyResponseModel deleteCompany(Integer cId){ //Delete specific company
        return company.remove(cId);
    }

    public CompanyResponseModel updateCompany (Integer cId, CompanyRequestModel companyRequest) { //Update Company
        if(company.containsKey(cId)){
            CompanyResponseModel storedCompany = company.get(cId);
            storedCompany.setCName(companyRequest.getCName());
            storedCompany.setCBalance(companyRequest.getCBalance());

            company.put(cId, storedCompany);
        }
        return company.get(cId);
    }
}

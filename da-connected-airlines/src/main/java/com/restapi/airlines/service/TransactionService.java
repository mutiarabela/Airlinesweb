package com.restapi.airlines.service;

import com.restapi.airlines.exception.TransactionNotFoundException;
import com.restapi.airlines.model.request.TransactionRequestModel;
import com.restapi.airlines.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private MembershipService membershipService;

    @Autowired
    private CompanyService companyService;

    TransactionResponseModel addTransaction;

    HashMap<Integer, TransactionResponseModel> transactions;

    public TransactionResponseModel createTransaction(TransactionRequestModel transactionRequestModel){

        addTransaction = new TransactionResponseModel();

        Integer uId = transactionRequestModel.getUId();
        Integer aId = transactionRequestModel.getAId();

        UserResponseModel userTemp = userService.getUser(uId);
        Integer mId = userTemp.getMId();
        Integer cId = userTemp.getCId();

        addTransaction.setUFirstName(userTemp.getUFirstName());
        addTransaction.setULastName(userTemp.getULastName());
        addTransaction.setUPhoneNum(userTemp.getUPhoneNum());
        addTransaction.setUEmail(userTemp.getUEmail());

        AirlineResponseModel airlineTemp = airlineService.getAirline(aId);
        addTransaction.setAName(airlineTemp.getAName());
        addTransaction.setADestination(airlineTemp.getADestination());
        addTransaction.setAAirportOrigin(airlineTemp.getAAirportOrigin());
        addTransaction.setAAirportDestin(airlineTemp.getAAirportDestin());
        addTransaction.setAPrice(airlineTemp.getAPrice());
        double aPrice = addTransaction.getAPrice();

        MembershipResponseModel membershipTemp = membershipService.getMembership(mId);
        addTransaction.setMDiscount(membershipTemp.getMDiscount());
        addTransaction.setMMessage(membershipTemp.getMMessage());

        CompanyResponseModel companyTemp = companyService.getCompany(cId);
        double cBeginingBalance = companyTemp.getCBalance();

        double tLuggage = transactionRequestModel.getTLuggage();
        tLuggage = (Math.ceil(tLuggage / 5.0)) * 300000.00;
        addTransaction.setTLuggage(tLuggage);

        addTransaction.setMDiscount(membershipTemp.getMDiscount());
        double mDiscount = addTransaction.getMDiscount();

        double totalPrice = aPrice - ((aPrice * mDiscount)/100) + tLuggage;
        addTransaction.setTTotPrice(totalPrice);

        if (transactions == null) {
            transactions = new HashMap<>();
        }

        if (cBeginingBalance >= totalPrice){
            double cEndingBalance = cBeginingBalance - totalPrice;
            companyTemp.setCBalance(cEndingBalance);
        } else {
            throw new TransactionNotFoundException("Company Balance is not enough!");
        }
        transactions.put(uId,addTransaction);

        return addTransaction;
    }

    private double totalTransaction(){
        double total = 0.00;
        Map<Integer, TransactionResponseModel> map = transactions;
        for (Map.Entry<Integer, TransactionResponseModel> entry : map.entrySet()) {
            total += entry.getValue().getTTotPrice();
        }
        return total;
    }

    public AllTransactionResponseModel getAllTransaction(){
        AllTransactionResponseModel allTransactionResponse = new AllTransactionResponseModel();
        allTransactionResponse.setTransaction(transactions.values());
        allTransactionResponse.setTotalTransaction(totalTransaction());
        return allTransactionResponse;
    }
}

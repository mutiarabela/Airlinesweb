package com.restapi.airlines.service;

import com.restapi.airlines.model.request.MembershipRequestModel;
import com.restapi.airlines.model.response.MembershipResponseModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MembershipService {
    MembershipResponseModel addMembership;

    HashMap<Integer, MembershipResponseModel> membership;

    public MembershipService(){ //Hardcode create Membership
        MembershipResponseModel addFirstMembership = new MembershipResponseModel();

        addFirstMembership.setMId(1);
        Integer idFirstMembership = addFirstMembership.getMId();

        addFirstMembership.setMName("Silver");
        addFirstMembership.setMDiscount(0.00);
        addFirstMembership.setMMessage("You don't get any discount, upgrade your membership to Gold for 10% Discount or Platinum for 20% Discount!");

        if(membership == null){
            membership = new HashMap<>();
        }

        membership.put(idFirstMembership, addFirstMembership);

        MembershipResponseModel addSecondMembership = new MembershipResponseModel();

        addSecondMembership.setMId(2);
        Integer idSecondMembership = addSecondMembership.getMId();

        addSecondMembership.setMName("Gold");
        addSecondMembership.setMDiscount(10.00);
        addSecondMembership.setMMessage("Congratulation you got 10% Discount! upgrade your membership to Platinum for 20% Discount! Enjoy!");

        membership.put(idSecondMembership, addSecondMembership);

        MembershipResponseModel addThirdMembership = new MembershipResponseModel();

        addThirdMembership.setMId(3);
        Integer idThirdMembership = addThirdMembership.getMId();

        addThirdMembership.setMName("Platinum");
        addThirdMembership.setMDiscount(20.00);
        addThirdMembership.setMMessage("Congratulation you got 20% Discount! Enjoy!");

        membership.put(idThirdMembership, addThirdMembership);
    }

    public MembershipResponseModel createMembership(MembershipRequestModel membershipRequest) { //Create Membership by input
        addMembership = new MembershipResponseModel();

        addMembership.setMId(membershipRequest.getMId());
        Integer mId = addMembership.getMId();

        addMembership.setMId(membershipRequest.getMId());
        addMembership.setMName(membershipRequest.getMName());
        addMembership.setMDiscount(membershipRequest.getMDiscount());
        addMembership.setMMessage(membershipRequest.getMMessage());

        membership.put(mId, addMembership);
        return addMembership;
    }

    public MembershipResponseModel getMembership (Integer mId){ //Get specific membership to view
        return membership.get(mId);
    }

    public Collection<MembershipResponseModel> getAllMembership(){ //Get all added membership
        return membership.values();
    }

    public MembershipResponseModel deleteMembership(Integer mId){ //Delete specific user
        return membership.remove(mId);
    }

    public MembershipResponseModel updateMembership (Integer mId, MembershipRequestModel membershipRequest) { //Update Membership
        if(membership.containsKey(mId)){
            MembershipResponseModel storedMembership = membership.get(mId);
            storedMembership.setMName(membershipRequest.getMName());
            storedMembership.setMDiscount(membershipRequest.getMDiscount());
            storedMembership.setMMessage(membershipRequest.getMMessage());

            membership.put(mId, storedMembership);
        }
        return membership.get(mId);
    }
}

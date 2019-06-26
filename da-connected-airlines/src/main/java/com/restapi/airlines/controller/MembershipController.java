package com.restapi.airlines.controller;

import com.restapi.airlines.exception.MembershipNotFoundException;
import com.restapi.airlines.model.request.MembershipRequestModel;
import com.restapi.airlines.model.response.MembershipResponseModel;
import com.restapi.airlines.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Memberships")
public class MembershipController {
    @Autowired
    MembershipService membershipService;

    @GetMapping(path = "/{mId}",
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getMembership(@PathVariable Integer mId){ //Get specific membership
        MembershipResponseModel getMembershipValue = membershipService.getMembership(mId);
        if (getMembershipValue != null) {
            return new ResponseEntity<>(getMembershipValue, HttpStatus.OK);
        } else {
            throw new MembershipNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllMembership(){ //Get all added Membership
        Collection getAllMembershipValue = membershipService.getAllMembership();
        return new ResponseEntity<>(getAllMembershipValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createMembership(@Valid @RequestBody MembershipRequestModel membershipRequest){ //Create membership
        MembershipResponseModel createMembershipValue = membershipService.createMembership(membershipRequest);
        return new ResponseEntity<>(createMembershipValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{mId}",
            consumes = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<MembershipResponseModel> updateMembership(@PathVariable Integer mId, @Valid @RequestBody MembershipRequestModel membershipRequest){ //Update Membership's phone number
        MembershipResponseModel updateMembershipValue = membershipService.updateMembership(mId, membershipRequest);
        if (updateMembershipValue != null) {
            return new ResponseEntity<>(updateMembershipValue, HttpStatus.OK);
        } else {
            throw new MembershipNotFoundException("Update Failed, Membership Not Found");
        }
    }

    @DeleteMapping(path = "/{mId}")
    public ResponseEntity deleteMembership(@PathVariable Integer mId){ //Delete Membership
        MembershipResponseModel deleteMembershipValue = membershipService.deleteMembership(mId);
        if (deleteMembershipValue != null) {
            return new ResponseEntity<>(deleteMembershipValue, HttpStatus.OK);
        } else {
            throw new MembershipNotFoundException("Delete Failed, Membership Not Found");
        }
    }
}

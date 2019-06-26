package com.restapi.airlines.controller;

import com.restapi.airlines.exception.UserNotFoundException;
import com.restapi.airlines.model.request.UserDetailsRequestModel;
import com.restapi.airlines.model.response.UserResponseModel;
import com.restapi.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{uId}",
                produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getUser(@PathVariable Integer uId){ //Get specific user
        UserResponseModel getUserValue = userService.getUser(uId);
        if (getUserValue != null) {
            return new ResponseEntity<>(getUserValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllUser(){ //Get all added user
        Collection getAllUserValue = userService.getAllUser();
        return new ResponseEntity<>(getAllUserValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE },
                 produces = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){ //Create user
        UserResponseModel createUserValue = userService.createUser(userDetails);
        return new ResponseEntity<>(createUserValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{uId}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UserResponseModel> updatePhoneNumUser(@PathVariable Integer uId, @Valid @RequestBody UserDetailsRequestModel userDetails){ //Update user's phone number
        UserResponseModel updatePhoneNumUserValue = userService.updateUser(uId, userDetails);
        if (updatePhoneNumUserValue != null) {
            return new ResponseEntity<>(updatePhoneNumUserValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Update Failed, User Not Found");
        }
    }

    @DeleteMapping(path = "/{uId}")
    public ResponseEntity deleteUser(@PathVariable Integer uId){ //Delete user
        UserResponseModel deleteUserValue = userService.deleteUser(uId);
        if (deleteUserValue != null) {
            return new ResponseEntity<>(deleteUserValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Delete Failed, User Not Found");
        }
    }

}
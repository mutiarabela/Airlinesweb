package com.restapi.airlines.service;

import com.restapi.airlines.model.request.UserDetailsRequestModel;
import com.restapi.airlines.model.response.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserService { //For User Service
    UserResponseModel addUser;

    HashMap<Integer, UserResponseModel> users;

    public UserService(){ //Hardcode create user
        UserResponseModel addFirstUser = new UserResponseModel();

        addFirstUser.setUId(1);
        int idFirstUser = addFirstUser.getUId();

        addFirstUser.setCId(1);
        addFirstUser.setMId(1);
        addFirstUser.setUFirstName("Mutiara");
        addFirstUser.setULastName("Bela");
        addFirstUser.setUPhoneNum("082111711170");
        addFirstUser.setUName("mutiarabela");
        addFirstUser.setUEmail("bela@gmail.com");

        if(users == null){
            users = new HashMap<>();
        }

        users.put(idFirstUser, addFirstUser);

        UserResponseModel addSecondUser = new UserResponseModel();

        addSecondUser.setUId(2);
        int idSecondUser = addSecondUser.getUId();

        addSecondUser.setCId(2);
        addSecondUser.setMId(2);
        addSecondUser.setUFirstName("Niall");
        addSecondUser.setULastName("Horan");
        addSecondUser.setUPhoneNum("081212999970");
        addSecondUser.setUName("niallhoran");
        addSecondUser.setUEmail("niall@gmail.com");

        users.put(idSecondUser, addSecondUser);

        UserResponseModel addThirdUser = new UserResponseModel();

        addThirdUser.setUId(3);
        int idThirdUser = addThirdUser.getUId();

        addThirdUser.setCId(3);
        addThirdUser.setMId(3);
        addThirdUser.setUFirstName("Nur");
        addThirdUser.setULastName("Falah");
        addThirdUser.setUPhoneNum("081218077761");
        addThirdUser.setUName("nurfalah");
        addThirdUser.setUEmail("falah@gmail.com");

        users.put(idThirdUser, addThirdUser);
    }

    public UserResponseModel createUser(UserDetailsRequestModel userDetails) { //Create user by input
        addUser = new UserResponseModel();

        addUser.setUId(userDetails.getUId());
        int idUser = addUser.getUId();

        addUser.setUId(userDetails.getUId());
        addUser.setCId(userDetails.getCId());
        addUser.setMId(userDetails.getMId());
        addUser.setUFirstName(userDetails.getUFirstName());
        addUser.setULastName(userDetails.getULastName());
        addUser.setUPhoneNum(userDetails.getUPhoneNum());
        addUser.setUName(userDetails.getUName());
        addUser.setUEmail(userDetails.getUEmail());

        users.put(idUser, addUser);
        return addUser;
    }

    public UserResponseModel getUser(int idUser) { //Get specific user to view
        return users.get(idUser);
    }

    public Collection <UserResponseModel> getAllUser(){ //Get all added user
        return users.values();
    }

    public UserResponseModel deleteUser(int idUser){ //Delete specific user
        return users.remove(idUser);
    }

    public UserResponseModel updateUser(int idUser, UserDetailsRequestModel userDetails) { //Update user phone nymber
        if(users.containsKey(idUser)){
            UserResponseModel storedUser = users.get(idUser);
            storedUser.setCId(userDetails.getCId());
            storedUser.setCId(userDetails.getCId());
            storedUser.setMId(userDetails.getMId());
            storedUser.setUFirstName(userDetails.getUFirstName());
            storedUser.setUFirstName(userDetails.getUFirstName());
            storedUser.setULastName(userDetails.getULastName());
            storedUser.setUPhoneNum(userDetails.getUPhoneNum());
            storedUser.setUName(userDetails.getUName());
            storedUser.setUEmail(userDetails.getUEmail());
            users.put(idUser, storedUser);
        }
        return users.get(idUser);
    }
}

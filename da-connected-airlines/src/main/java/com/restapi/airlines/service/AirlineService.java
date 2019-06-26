package com.restapi.airlines.service;

import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class AirlineService { //Airline Service
    AirlineResponseModel addAirline;

    HashMap<Integer, AirlineResponseModel> airlines;

    public AirlineService(){ //Create Airline through hardcode
        AirlineResponseModel addFirstAirline = new AirlineResponseModel();

        addFirstAirline.setAId(1);
        Integer idAirline1 = addFirstAirline.getAId();

        addFirstAirline.setAName("Garuda");
        addFirstAirline.setAType("Boeing G1");
        addFirstAirline.setAAirportOrigin("Seokarno Hatta");
        addFirstAirline.setAAirportDestin("Adi Soetjipto");
        addFirstAirline.setADestination("Yogyakarta");
        addFirstAirline.setAPrice(1550000.00);

        if(airlines == null){
            airlines = new HashMap<>();
        }

        airlines.put(idAirline1, addFirstAirline);

        AirlineResponseModel addSecondAirline = new AirlineResponseModel();

        addSecondAirline.setAId(2);
        Integer idAirline2 = addSecondAirline.getAId();

        addSecondAirline.setAName("Citilink");
        addSecondAirline.setAType("Boeing C1");
        addSecondAirline.setAAirportOrigin("Halim Perdana Kusuma");
        addSecondAirline.setAAirportDestin("Adi Soetjipto");
        addSecondAirline.setADestination("Yogyakarta");
        addSecondAirline.setAPrice(750000.00);

        airlines.put(idAirline2, addSecondAirline);

        AirlineResponseModel addThirdAirline = new AirlineResponseModel();

        addThirdAirline.setAId(3);
        Integer idAirline3 = addThirdAirline.getAId();

        addThirdAirline.setAName("Citilink");
        addThirdAirline.setAType("Boeing C2");
        addThirdAirline.setAAirportOrigin("Halim Perdana Kusuma");
        addThirdAirline.setAAirportDestin("Juanda");
        addThirdAirline.setADestination("Surabaya");
        addThirdAirline.setAPrice(1050000.00);

        airlines.put(idAirline3, addThirdAirline);

    }

    public AirlineResponseModel createAirline(AirlineDetailsRequestModel airlineDetails) { //Create Airline through input
        addAirline = new AirlineResponseModel();

        addAirline.setAId(airlineDetails.getAId());
        Integer aId = addAirline.getAId();

        addAirline.setAId(airlineDetails.getAId());
        addAirline.setAName(airlineDetails.getAName());
        addAirline.setAType(airlineDetails.getAType());
        addAirline.setADestination(airlineDetails.getADestination());
        addAirline.setAAirportOrigin(airlineDetails.getAAirportOrigin());
        addAirline.setAAirportDestin(airlineDetails.getAAirportDestin());
        addAirline.setAPrice(airlineDetails.getAPrice());

        airlines.put(aId, addAirline);
        return addAirline;
    }

    public AirlineResponseModel getAirline (Integer aId){ //Get specific Airline
        return airlines.get(aId);
    }

    public Collection<AirlineResponseModel> getAllAirline(){ //Get all Airline
        return airlines.values();
    }

    public AirlineResponseModel deleteAirline(Integer aId){ //Delete specific Airline
        return airlines.remove(aId);
    }

    public AirlineResponseModel updateAirline (Integer aId, AirlineDetailsRequestModel airlineDetails) { //Update specific price Airline
        if(airlines.containsKey(aId)){
            AirlineResponseModel storedAirline = airlines.get(aId);
            storedAirline.setAName(airlineDetails.getAName());
            storedAirline.setAType(airlineDetails.getAType());
            storedAirline.setADestination(airlineDetails.getADestination());
            storedAirline.setAAirportOrigin(airlineDetails.getAAirportOrigin());
            storedAirline.setAAirportDestin(airlineDetails.getAAirportDestin());
            storedAirline.setAPrice(airlineDetails.getAPrice());

            airlines.put(aId, storedAirline);
        }
        return airlines.get(aId);
    }
}

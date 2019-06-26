package com.restapi.airlines.controller;

import com.restapi.airlines.exception.AirlineNotFoundException;
import com.restapi.airlines.model.request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.response.AirlineResponseModel;
import com.restapi.airlines.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Airlines")
public class AirlineController { //Airloine controller

    @Autowired
    AirlineService airlineService;

    @GetMapping(path = "/{aId}",
                produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getAirline(@PathVariable Integer aId){ //Get specific Airline
        AirlineResponseModel getAirlineValue = airlineService.getAirline(aId);
        if (getAirlineValue != null) {
            return new ResponseEntity<>(getAirlineValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllAirline(){ //Get all Airline
        Collection getAllAirlineValue = airlineService.getAllAirline();
        return new ResponseEntity<>(getAllAirlineValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createAirline(@Valid @RequestBody AirlineDetailsRequestModel airlineDetails){ //Create Airline
        AirlineResponseModel createAirlineValue = airlineService.createAirline(airlineDetails);
        return new ResponseEntity<>(createAirlineValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{aId}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<AirlineResponseModel> updatePriceAirline(@PathVariable Integer aId, @Valid @RequestBody AirlineDetailsRequestModel airlineDetails){ //Update Airline
        AirlineResponseModel updatePriceAirlineValue = airlineService.updateAirline(aId, airlineDetails);
        if (updatePriceAirlineValue != null) {
            return new ResponseEntity<>(updatePriceAirlineValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException("Update Airline Failed, Airline Not Found");
        }
    }

    @DeleteMapping(path = "/{aId}")
    public ResponseEntity deleteAirline(@PathVariable Integer aId){ //Delete Airline
        AirlineResponseModel deleteAirlineValue = airlineService.deleteAirline(aId);
        if (deleteAirlineValue != null) {
            return new ResponseEntity<>(deleteAirlineValue, HttpStatus.OK);
        } else {
            throw new AirlineNotFoundException("Delete Airline Failed, Airline Not Found");
        }
    }
}

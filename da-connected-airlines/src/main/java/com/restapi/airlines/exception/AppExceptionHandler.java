package com.restapi.airlines.exception;

import com.restapi.airlines.model.response.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class AppExceptionHandler { //Application exception handling
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerUserNotFoundException(UserNotFoundException ex) { //Handling User not found error
        log.error(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                .message("User ID you sent is invalid / not match")
                .errors(new String[]{ex.getMessage()})
                .build()
        );
    }

    @ExceptionHandler({AirlineNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerAirlineNotFoundException(AirlineNotFoundException ex) { //Handling Airline not found
        log.error(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                        .message("Airline ID you sent is invalid / not match")
                        .errors(new String[]{ex.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler({MembershipNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerMembershipNotFoundException(MembershipNotFoundException ex) { //Handling Membership not found
        log.error(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                        .message("Membership ID you sent is invalid / not match")
                        .errors(new String[]{ex.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler({CompanyNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerCompanyNotFoundException(CompanyNotFoundException ex) { //Handling Company not found
        log.error(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                        .message("Company ID you sent is invalid / not match")
                        .errors(new String[]{ex.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) { //Handling Method argument not valid
        log.error(ex.getMessage());

        String[] errors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + " " + f.getDefaultMessage())
                .toArray(String[]::new);

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                .message("Argument is invalid / not match")
                .errors(errors)
                .build()
        );
    }
}

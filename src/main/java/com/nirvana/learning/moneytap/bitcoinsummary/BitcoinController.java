package com.nirvana.learning.moneytap.bitcoinsummary;


import com.nirvana.learning.moneytap.bitcoinsummary.exception.ResourceNotFoundException;
import com.nirvana.learning.moneytap.bitcoinsummary.util.CustomMessageSource;
import com.nirvana.learning.moneytap.bitcoinsummary.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitcoinController {

    @Autowired
    CustomMessageSource customMessageSource;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBitCoinSummary(@PathVariable("id") int id) throws ResourceNotFoundException {
        return sendSuccessResponse("bitcoinsummary.success");
    }

    protected ResponseEntity<ResponseWrapper<String>> sendSuccessResponse(String successMsg) {
        return sendSuccessResponse(successMsg, HttpStatus.OK);
    }

    protected ResponseEntity<ResponseWrapper<String>> sendSuccessResponse(String successMsg, HttpStatus httpStatus) {
        return new ResponseEntity<ResponseWrapper<String>>(
                new ResponseWrapper<String>(customMessageSource.getMessage(successMsg)), httpStatus);
    }
}

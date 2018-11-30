package com.iheart.advertisers.controllers;

import com.iheart.advertisers.Repo.AdvertiserRepository;
import com.iheart.advertisers.models.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advertiser")
public class AdvertiserController {

    @Autowired
    AdvertiserRepository advertiserRepository;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Advertiser> createAdvertiser(@RequestBody Advertiser createdAdvertiser) {
        Integer success = advertiserRepository.insert(createdAdvertiser);

        if (success != 0)
            return new ResponseEntity<>(createdAdvertiser, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAdvertiser(@RequestBody Advertiser updatedAdvertiser) {
        Integer success = advertiserRepository.update(updatedAdvertiser);

        switch(success) {
            case 0: return new ResponseEntity<>(HttpStatus.CREATED);
            case 1: return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAdvertiser(@RequestBody Advertiser deletedAdvertiser) {
        Integer success = advertiserRepository.delete(deletedAdvertiser.getAdvertiserName());

        if (success != 0)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Advertiser> getAdvertiser(@RequestParam("advertiserName") String advertiserName) {
        Advertiser retrievedAdvertiser = advertiserRepository.getAdvertiser(advertiserName);
        if (retrievedAdvertiser != null)
            return new ResponseEntity<>(retrievedAdvertiser, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<String> advertiserException(Exception e) {

        return new ResponseEntity<>("Error With Advertiser Request", HttpStatus.CONFLICT);
    }


}

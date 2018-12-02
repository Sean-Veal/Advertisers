package com.iheart.advertisers.controllers;

import com.iheart.advertisers.Repo.AdvertiserRepository;
import com.iheart.advertisers.models.Advertiser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advertiser")
@Api(description = "Set of endpoints for Creating, Reading, Updating, and Deleting Advertisers.")
public class AdvertiserController {

    @Autowired
    AdvertiserRepository advertiserRepository;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Creates an Advertiser. Returns 400 if process can't be completed.")
    public ResponseEntity<Advertiser> createAdvertiser(
            @ApiParam("Values to Create an Advertiser. advertiserName cannot be empty")
            @RequestBody Advertiser createdAdvertiser) {
        if (createdAdvertiser.getAdvertiserName().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Integer success = advertiserRepository.insert(createdAdvertiser);

        if (success != 0)
            return new ResponseEntity<>(createdAdvertiser, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Updates an Advertiser or creates one if the Advertiser doesn't exist. Returns 400 if process can't be completed")
    public ResponseEntity<String> updateAdvertiser(
            @ApiParam("Values to Create an Advertiser. advertiserName cannot be empty")
            @RequestBody Advertiser updatedAdvertiser) {
        if (updatedAdvertiser.getAdvertiserName().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Integer success = advertiserRepository.update(updatedAdvertiser);

        switch (success) {
            case 0:
                return new ResponseEntity<>(HttpStatus.CREATED);
            case 1:
                return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //TODO: Update if you can figure out how to add an ID
    @RequestMapping(method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Deletes an Advertiser. Returns 404 if process can't be completed.")
    public ResponseEntity<String> deleteAdvertiser(
            @ApiParam("Values to delete an Advertiser. Very dependent on advertiserName")
            @RequestBody Advertiser deletedAdvertiser) {
        Integer success = advertiserRepository.delete(deletedAdvertiser.getAdvertiserName());

        if (success != 0)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO: Update if you can figure out how to add an ID
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Retrieves Advertiser based on advertiserName. Returns 404 if process can't be completed.")
    public ResponseEntity<Advertiser> getAdvertiser(
            @ApiParam("advertiserName of the Advertiser")
            @RequestParam("advertiserName") String advertiserName) {
        Advertiser retrievedAdvertiser = advertiserRepository.getAdvertiser(advertiserName);
        if (retrievedAdvertiser != null)
            return new ResponseEntity<>(retrievedAdvertiser, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<String> advertiserException(Exception e) {

        return new ResponseEntity<>("Error With Advertiser Request", HttpStatus.CONFLICT);
    }


}

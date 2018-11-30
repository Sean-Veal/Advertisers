package com.iheart.advertisers.controllers;

import com.iheart.advertisers.Repo.AdvertiserRepository;
import com.iheart.advertisers.models.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertiser")
public class AdvertiserController {

    @Autowired
    AdvertiserRepository advertiserRepository;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAdvertiser(@RequestBody Advertiser createdAdvertiser) {
        System.out.println("Advertiser!!!!!!!!!!!!!!" + createdAdvertiser.toString());
        Integer success = advertiserRepository.insert(createdAdvertiser);

        if (success != 0)
            return new ResponseEntity<>(HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

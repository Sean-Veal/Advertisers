package com.iheart.advertisers;

import com.iheart.advertisers.Repo.AdvertiserRepository;
import com.iheart.advertisers.models.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvertisersApplication implements CommandLineRunner {

    @Autowired
    AdvertiserRepository advertiserRepository;

    public static void main(String[] args) {

        SpringApplication.run(AdvertisersApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(advertiserRepository.getAllAdvertisers().toString());
        System.out.println(advertiserRepository.insert(new Advertiser("Batman",
                "Bruce Wayne", 300.00)));
    }
}

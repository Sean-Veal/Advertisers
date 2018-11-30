package com.iheart.advertisers.Repo;

import com.iheart.advertisers.models.Advertiser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdvertiserRepository {

    @Insert("INSERT INTO ADVERTISER(advertiserName, contactName, creditLimit) " +
            "VALUES (#{advertiserName}, #{contactName},#{creditLimit})")
    public Integer insert(Advertiser advertiser);

    @Select("SELECT * FROM ADVERTISER")
    public List<Advertiser> getAllAdvertisers();
}

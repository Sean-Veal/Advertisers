package com.iheart.advertisers.Repo;

import com.iheart.advertisers.models.Advertiser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdvertiserRepository {

    @Insert("INSERT INTO ADVERTISER(advertiserName, contactName, creditLimit) " +
            "VALUES (#{advertiserName}, #{contactName},#{creditLimit})")
    public Integer insert(Advertiser advertiser);

    @Update("Update ADVERTISER SET advertiserName=#{advertiserName}, contactName=#{contactName}, " +
            "creditLimit=#{creditLimit} where advertiserName=#{advertiserName}")
    public Integer update(Advertiser advertiser);

    @Delete("DELETE FROM ADVERTISER WHERE advertiserName = #{advertiserName}")
    public Integer delete(String advertiserName);

    @Select("SELECT * FROM ADVERTISER WHERE advertiserName = #{advertiserName}")
    public Advertiser getAdvertiser(String advertiserName);
}

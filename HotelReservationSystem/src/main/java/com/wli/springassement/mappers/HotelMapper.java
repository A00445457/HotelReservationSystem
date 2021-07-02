package com.wli.springassement.mappers;

import com.wli.springassement.entities.HotelDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelMapper {

    @Select("SELECT * FROM TBL_HOTELDETAIL")
    List<HotelDetail> findAll();
}

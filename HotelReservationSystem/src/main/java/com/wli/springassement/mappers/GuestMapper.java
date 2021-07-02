package com.wli.springassement.mappers;

import com.wli.springassement.entities.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuestMapper {

    @Select("SELECT * FROM TBL_GUEST ")
    List<Guest> findAll();

    @Select("SELECT g.* FROM TBL_GUEST g inner join TBL_RESERVATIONGUEST rg on g.gid=rg.gid where rg.rid=#{rid}")
    List<Guest> findGuestByReservationId(int rid);
}

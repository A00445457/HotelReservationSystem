package com.wli.springassement.mappers;

import com.wli.springassement.entities.Guest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuestMapper {

    @Select("SELECT * FROM TBL_GUEST ")
    List<Guest> findAll();

    @Select("SELECT g.* FROM TBL_GUEST g inner join TBL_RESERVATIONGUEST rg on g.gid=rg.gid where rg.rid=#{rid}")
    List<Guest> findGuestByReservationId(int rid);

    @Insert({"INSERT INTO TBL_GUEST (firstName, lastName, age, gender) VALUES (#{firstName}, #{lastName}, #{age}, #{gender})"})
    @Options(useGeneratedKeys = true, keyProperty = "gid")
    int insertGuest(Guest guest);

    @Select({"<script>SELECT * FROM TBL_GUEST g "+
            "<where>"+
            "  1=1" +
            "  <if test='firstName!=null'>and firstName=#{firstName}</if> "+
            "  <if test='lastName!=null'>and lastName=#{lastName}</if>"+
            "</where>"+
            "</script>"})
    List<Guest> findGuestByName(String firstName, String lastName);
}

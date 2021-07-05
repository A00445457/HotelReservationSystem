package com.wli.springassement.mappers;

import com.wli.springassement.entities.Guest;
import com.wli.springassement.entities.ReservationDetails;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface ReservationMapper {

    @Results({
            @Result(property = "rid", column = "rid"),
            @Result(property = "hotel_name", column = "hotel_name"),
            @Result(property = "checkin", column = "checkin"),
            @Result(property = "checkout", column = "checkout"),
            @Result(property = "guest_list" ,column = "rid", javaType = List.class,
                    many = @Many(select = "com.wli.springassement.mappers.GuestMapper.findGuestByReservationId"))
    })
    @Select("SELECT distinct r.* FROM TBL_RESERVATIONGUEST rg inner join TBL_RESERVATION r on rg.rid=r.rid")
    List<ReservationDetails> findAll();

    @Results({
            @Result(property = "rid", column = "rid"),
            @Result(property = "hotel_name", column = "hotel_name"),
            @Result(property = "checkin", column = "checkin"),
            @Result(property = "checkout", column = "checkout"),
            @Result(property = "guest_list" ,column = "rid", javaType = List.class,
                    many = @Many(select = "com.wli.springassement.mappers.GuestMapper.findGuestByReservationId"))
    })

    @Select({"<script>SELECT distinct r.* FROM TBL_RESERVATIONGUEST rg inner join TBL_RESERVATION r on rg.rid=r.rid "+
            "<where>"+
            "  1=1" +
            "  <if test='firstName!=null and lastName!=null'>" +
            "and (rg.rid in (SELECT rg.rid FROM TBL_RESERVATIONGUEST rg inner join TBL_GUEST g on g.gid=rg.gid where lastName=#{lastName} and firstName=#{firstName}))</if> "+
            "</where>"+
            "</script>"})
    List<ReservationDetails> findReservationByName(String firstName, String lastName);

    @Insert({"INSERT INTO TBL_RESERVATION  (hotel_name, checkin, checkout, confirm) VALUES (#{hotel_name}, #{checkin}, #{checkout}, #{confirm});"})
    @Options(useGeneratedKeys = true, keyProperty = "rid", keyColumn = "rid")
    int insertReservation(ReservationDetails reservationDetails);

    @Insert({"INSERT INTO TBL_RESERVATIONGUEST  (gid, rid) VALUES (#{gid}, #{rid});"})
    void insertReservationGuest(int rid, int gid);
}

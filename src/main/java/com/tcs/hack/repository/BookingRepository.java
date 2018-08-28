package com.tcs.hack.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcs.hack.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer>{
	@Query("select count(*) from Booking B where B.resource.resourceId = :resourceId and B.bookingDate = :date and B.bookingSlot = :slot")
	public int findAvailability(@Param("resourceId")int resourceId, @Param("date")java.sql.Date date,@Param("slot") String slot);

	@Query("select B from Booking B where B.bookingId = :bookingId")
	public Booking findOne(@Param("bookingId") int bookingId);
}

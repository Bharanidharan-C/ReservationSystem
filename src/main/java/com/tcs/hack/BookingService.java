package com.tcs.hack;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tcs.hack.dto.BookingDTO;
import com.tcs.hack.model.Booking;
import com.tcs.hack.model.Resource;
import com.tcs.hack.repository.BookingRepository;
import com.tcs.hack.repository.ResourceRepository;

@Service
public class BookingService { 
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired 
		ResourceRepository resourceRepository;
	                       
	 List<Resource> findAllResorces() {
		return (List<Resource>) resourceRepository.findAll();
	}
	
	 Resource getResource(int id) {
		Resource r = resourceRepository.findById(id).get();
		return r;
	 }
	 
	 Resource addResource(Resource r) {
		
		 return resourceRepository.save(r);
	 }
	 
	 Resource updateResource(int resourceId,Resource updatedResource) throws Exception{
		 return resourceRepository.findById(resourceId).map(resource -> {
	            resource.setResourceName(updatedResource.getResourceName());
	            return resourceRepository.save(resource);
	        }).orElseThrow(() -> new Exception("PostId " + resourceId + " not found", null));
	 }
	
	
	void deleteResource(int id) {
		
	  resourceRepository.deleteById(id);
	 }
	
	Iterable<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	Booking addReservation(BookingDTO toBook) throws Exception{
		String a[] = toBook.getBookingDate().split("-");
		Date date = new Date(Integer.parseInt(a[2]),Integer.parseInt(a[2]), Integer.parseInt(a[2]));
		
		 int reservedCount = bookingRepository.findAvailability(toBook.getResourceId(), date,toBook.getBookingSlot());
		 if(reservedCount ==0) {
			 resourceRepository.findById(toBook.getResourceId()).map(resource ->{
				 Booking booking = new Booking(date, toBook.getBookingSlot(), resource);
				return bookingRepository.save(booking);
			 }).orElseThrow(() -> new Exception("resourceId " + toBook.getResourceId() + " not available"));
		 }
		 return null;
	}
	
	
}

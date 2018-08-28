package com.tcs.hack;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.tcs.hack.model.Booking;
import com.tcs.hack.model.Resource;
import com.tcs.hack.repository.BookingRepository;
import com.tcs.hack.repository.ResourceRepository;

@Service("bookingService")
public class BookingService { 
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired 
		ResourceRepository resourceRepository;
	                       
	 List<Resource> findAllResorces() {
		return (List<Resource>) resourceRepository.findAll();
	}
	
	 Resource getResource(int id) {
		 return resourceRepository.findById(id).get();
	 }
	 
	 Resource addResource(Resource r) {
		
		 return resourceRepository.save(r);
	 }
	 
	 Resource updateResource(int resourceId,Resource updatedResource) {
		 return resourceRepository.findById(resourceId).map(resource -> {
	            resource.setResourceName(updatedResource.getResourceName());
	            return resourceRepository.save(resource);
	        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + resourceId + " not found", null));
	 }
	
	
	void deleteResource(int id) {
		
	  resourceRepository.deleteById(id);
	 }
	
	Iterable<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	Booking addReservation(int resourceId, Booking booking) {
		 int reservedCount = bookingRepository.findAvailability(resourceId, booking.getBookingDate(),booking.getBookingSlot());
		 if(reservedCount ==0) {
			 resourceRepository.findById(resourceId).map(resource ->{
				 booking.setResource(resource);
				return bookingRepository.save(booking);
			 }).orElseThrow(() -> new ResourceNotFoundException("resourceId " + resourceId + " not found", null));
		 }
		 return null;
	}
	
	
}

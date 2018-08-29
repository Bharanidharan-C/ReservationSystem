package com.tcs.hack;



import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.hack.dto.BookingDTO;
import com.tcs.hack.model.Booking;
import com.tcs.hack.model.Resource;
import com.tcs.hack.repository.BookingRepository;
import com.tcs.hack.repository.ResourceRepository;

@RestController
public class Controller {
	


@Autowired
BookingService bookingService;

@GetMapping("/tcs/hack/v1/resources")
Iterable<Resource> findAllResorces() {
	return bookingService.findAllResorces();
}

@GetMapping("/tcs/hack/v1/resources/{id}")
Resource getResource(@PathVariable int id) {
	try
	{
	 return bookingService.getResource(id);
	}catch(Exception e) {
		return null;
	}
 }
 
@PostMapping("/tcs/hack/v1/resources")
@ResponseStatus(HttpStatus.CREATED)
 Resource addResource(@Valid @RequestBody Resource r) {
	
	 return bookingService.addResource(r);
}

@PostMapping("/tcs/hack/v1/resources/{resourceId}")
 Resource updateResource(@PathVariable int resourceId,Resource updatedResource) throws Exception {
	 return bookingService.updateResource(resourceId, updatedResource);
 }

@DeleteMapping("/tcs/hack/v1/resources")
void deleteResource(@Valid @RequestBody Resource resource) {
	 bookingService.deleteResource(resource.getResourceId());
 }

@GetMapping("/tcs/hack/v1/reservations")
Iterable<Booking> getAllBookings(){
	return bookingService.getAllBookings();
}

@PostMapping("/tcs/hack/v1/reservations")
@ResponseStatus(HttpStatus.CREATED)
Booking addReservation( @Valid @RequestBody BookingDTO bookingDTO) throws Exception {
	
	
	return bookingService.addReservation(bookingDTO);
}


}

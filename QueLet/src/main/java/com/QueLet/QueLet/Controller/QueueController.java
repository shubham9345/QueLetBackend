package com.QueLet.QueLet.Controller;

import com.QueLet.QueLet.Model.Appointment;
import com.QueLet.QueLet.Model.Business;
import com.QueLet.QueLet.Model.Customer;
import com.QueLet.QueLet.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book-appointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment request) {
        Business business = request.getBusiness();
        Customer customer = request.getCustomer();
        // This position might ideally be generated dynamically within the service
        Integer position = 1;
        Appointment appointment = appointmentService.addAppointment(business, customer, position);
        position++;
        return ResponseEntity.ok(appointment);
    }
}
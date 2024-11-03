package com.QueLet.QueLet.Service;

import com.QueLet.QueLet.Model.Appointment;
import com.QueLet.QueLet.Model.Business;
import com.QueLet.QueLet.Model.Customer;
import com.QueLet.QueLet.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public Appointment addAppointment(Business business, Customer customer, Integer position) {
        Appointment appointment = new Appointment();
        appointment.setCustomer(customer);
        appointment.setPosition(position);
        appointment.setBusiness(business);
        return appointmentRepository.save(appointment);
    }

}
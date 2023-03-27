package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetEmployeeRequest;
import io.spring.guides.gs_producing_web_service.GetEmployeeResponse;

@Endpoint
public class EmployeeEndPoint {
	
	private static final String NAMESPACE_URI = "http://www.hdfc.com/api/employees";
	
	
	@Autowired
	private  EmployeeRepository repo;
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getCountry(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		response.setEmployee(repo.findEmployeeById(request.getEid()));

		return response;
	}
	

}

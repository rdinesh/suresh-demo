package com.example.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Status;
import com.example.domain.TransactionContext;

public class DemoClient {
	
	public static final String SERVICE_URL ="http://localhost:9090/demo/transaction";
	
	public Status callService(TransactionContext transaction) 
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Status> response = restTemplate.postForEntity(SERVICE_URL, transaction, Status.class);
		return response.getBody();
	}

	public static void main(String[] args) {
		
		TransactionContext requestObject = new TransactionContext();
		requestObject.setId("1000");
		requestObject.setName("test");
		requestObject.setDesc("this is a test description");
		DemoClient client = new DemoClient();
		
		Status s = client.callService(requestObject);
		System.out.println(s);
		// TODO Auto-generated method stub

	}

}

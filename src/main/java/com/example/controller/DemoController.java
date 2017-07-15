package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Status;
import com.example.domain.TransactionContext;


@RestController
public class DemoController {
	
	
	@RequestMapping(value="/demo/transaction",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public ResponseEntity<Status> addTransaction(@RequestBody TransactionContext transaction)
	{
		//do the business for updating the into to db by using Service
		
		Status s = new Status();
		s.setMessage("success");
		s.setCode(HttpStatus.CREATED.toString());
		return new ResponseEntity<Status>(s,HttpStatus.CREATED);
	}

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(){
		
		return "Test success";
	}
}

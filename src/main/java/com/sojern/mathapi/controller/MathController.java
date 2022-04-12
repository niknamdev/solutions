package com.sojern.mathapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sojern.mathapi.entity.RequestInput;
import com.sojern.mathapi.service.MathService;

@RestController
public class MathController {
	
	@Autowired
	MathService mathService;
	
	/**
	 * This method find minimum of given list of numbers and a quantifier (how many) provides min number(s)
	 * 
	 */
	@PostMapping("/min")
	public List<Integer> findMinimum(@RequestBody RequestInput input) {
		
		return mathService.findMinimum(input.getList(), input.getQ());
	}

	/**
	 * This method find  max - given list of numbers and a quantifier (how many) provides max number(s)
	 * 
	 */
	@PostMapping("/max")
	public List<Integer> findMaximum(@RequestBody RequestInput input) {
		return mathService.findMaximum(input.getList(), input.getQ());
	}

	/**
	 * This method find avg - given list of numbers calculates their average
	 * 
	 */
	@PostMapping("/avg")
	public Integer findAverage(@RequestBody RequestInput input) {
		return mathService.findAverage(input.getList());
	}

	/**
	 * This method find median - given list of numbers calculates their median
	 * 
	 */
	@PostMapping("/median")
	public Integer findMedian(@RequestBody RequestInput input) {
		return mathService.findMedian(input.getList());
	}

	/**
	 * This method find percentile of a given list of numbers and quantifier 'q', compute the qth percentile of the list elements
	 * 
	 */
	@PostMapping("/percentile")
	public Integer findPercentile(@RequestBody RequestInput input) {
		return mathService.findPercentile(input.getList(), input.getQ());
	}
	
	@GetMapping("/error")
	 public String getErrorPath() {
	        return "No Mapping Found";
	    }

}

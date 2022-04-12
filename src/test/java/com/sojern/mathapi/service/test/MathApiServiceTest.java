package com.sojern.mathapi.service.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sojern.mathapi.service.MathService;
import com.sojern.mathapi.service.MathServiceImpl;

public class MathApiServiceTest {

	List<Integer> list;
	MathService mathService;

	@BeforeEach
	public void setList() {

		mathService = new MathServiceImpl();
		list = Stream.of(7, 56, 2, 5, 4, 41, 88, 9, 6, 3, 72, 1, 8, 11, 15).collect(Collectors.toList());

	}
	
	@Test
	public void findMinimumTest() {
		
		List<Integer> min = mathService.findMinimum(list, 5);
		List<Integer> collect = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
		assertArrayEquals(min.toArray(), collect.toArray(), "result");
	}
	
	@Test
	public void findMaximumTest() {
		
		List<Integer> max = mathService.findMaximum(list, 3);
		List<Integer> collect = Stream.of(88, 72, 56).collect(Collectors.toList());
		assertArrayEquals(max.toArray(), collect.toArray(), "result");
	}
	
	@Test
	public void findAverageTest() {
		
		int avg = mathService.findAverage(list);
		assertEquals(avg, 21, "result");
	}
	
	@Test
	public void findMedianTest() {
		
		int median = mathService.findMedian(list);
		assertEquals(median, 8, "result");
	}
	
	@Test
	public void findPercentileTest() {
		
		int percentile = mathService.findPercentile(list, 85);
		assertEquals(percentile, 56, "result");
	}
	

}

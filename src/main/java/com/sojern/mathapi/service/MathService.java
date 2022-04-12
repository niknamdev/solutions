package com.sojern.mathapi.service;

import java.util.List;

public interface MathService {

	public List<Integer> findMinimum(List<Integer> numbers, int qualifier);

	public List<Integer> findMaximum(List<Integer> numbers, int qualifier);

	public Integer findAverage(List<Integer> numbers);

	public Integer findMedian(List<Integer> numbers);

	public Integer findPercentile(List<Integer> numbers, int qualifier);

}

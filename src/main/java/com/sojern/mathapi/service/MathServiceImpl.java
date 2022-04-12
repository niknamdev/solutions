package com.sojern.mathapi.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {

	@Override
	public List<Integer> findMinimum(List<Integer> numbers, int qualifier) {
		List<Integer> list = new ArrayList<Integer>();
		if (numbers != null && !numbers.isEmpty() && qualifier > 0) {
			List<Integer> collect = numbers.stream().sorted().collect(Collectors.toList());
			list = collect.subList(0, qualifier);
		}
		return list;
	}

	@Override
	public List<Integer> findMaximum(List<Integer> numbers, int qualifier) {
		List<Integer> list = new ArrayList<Integer>();
		if (numbers != null && !numbers.isEmpty() && qualifier > 0) {
			List<Integer> collect = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			list = collect.subList(0, qualifier);
		}
		return list;
	}

	@Override
	public Integer findAverage(List<Integer> numbers) {
		Integer average = -1;
		if (numbers != null && !numbers.isEmpty()) {
			OptionalDouble value = numbers.stream().mapToInt(x -> x).average();
			if (value.isPresent()) {
				double avg = value.getAsDouble();
				average = (int) avg;
			}
		}
		return average;
	}

	@Override
	public Integer findMedian(List<Integer> numbers) {
		int median = -1;

		if (numbers != null && !numbers.isEmpty()) {
			numbers.sort(Comparator.naturalOrder());
			int length = numbers.size();
			if (length % 2 == 0)
				median = (numbers.get(length / 2) + numbers.get(length / 2 - 1)) / 2;
			else
				median = numbers.get(length / 2);
		}
		return median;
	}

	@Override
	public Integer findPercentile(List<Integer> numbers, int qualifier) {
		if (numbers != null && !numbers.isEmpty()) {
			numbers.sort(Comparator.naturalOrder());
			double rank = Math.floor((numbers.size() * qualifier) / 100);
			return numbers.get((int)rank);
		}
		return -1;
	}

}

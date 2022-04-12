package com.sojern.mathapi.entity;

import java.util.List;

public class RequestInput {

	private List<Integer> list;

	private int q;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

	@Override
	public String toString() {
		return "RequestInput [list=" + list + ", q=" + q + "]";
	}

}

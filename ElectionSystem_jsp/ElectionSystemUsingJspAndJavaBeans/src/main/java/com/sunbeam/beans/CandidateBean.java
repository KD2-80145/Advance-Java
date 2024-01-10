package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateBean {
	List<Candidate> candList;
	public CandidateBean() {
		candList = new ArrayList<Candidate>();
	}
	public List<Candidate> getCandList() {
		return candList;
	}
	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void getCandidates() {
		try(CandidateDao cd = new CandidateDaoImpl())
		{
			candList = cd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

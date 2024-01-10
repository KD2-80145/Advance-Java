package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultBeans {
	List<Candidate> candLise;
	public ResultBeans() {
		candLise = new ArrayList<Candidate>();
	}
	public List<Candidate> getCandLise() {
		return candLise;
	}
	public void setCandLise(List<Candidate> candLise) {
		this.candLise = candLise;
	}
	public void getResult() {
		try(CandidateDao cd = new CandidateDaoImpl())
		{
			this.candLise = cd.getCandidatewiseVotes()	;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

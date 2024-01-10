package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class FindCandBean {
	int id;
	String name;
	String party;
	int votes;
	
	public FindCandBean() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public void find()
	{
		try(CandidateDao cd = new CandidateDaoImpl())
		{
			Candidate c = cd.findById(id);
			setName(c.getName());
			setParty(c.getParty());
			setVotes(c.getVotes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

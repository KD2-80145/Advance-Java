package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateCandidate {
	int id;
	String name;
	String party;
	int votes;
	String message;
	
	public UpdateCandidate() {
		
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
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void update()
	{
		Candidate c = new Candidate(id,name,party,votes);
		try(CandidateDao cd = new CandidateDaoImpl()){
			int cnt = cd.update(c);
			this.message = "Candidates Updated :" + cnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

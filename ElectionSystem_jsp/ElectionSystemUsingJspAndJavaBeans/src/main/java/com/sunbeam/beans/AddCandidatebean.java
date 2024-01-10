package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class AddCandidatebean {
	int id;
	String name;
	String party;
	int votes;
	boolean status;
	
	public AddCandidatebean() {
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void save()
	{
		Candidate c = new Candidate(id,name,party,votes);
		try(CandidateDao cd = new CandidateDaoImpl()){
			int cnt = cd.save(c);
			if(cnt == 1)
				this.status = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

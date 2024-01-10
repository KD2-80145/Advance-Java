package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
	User user;
	
	int candidateId;
	String message;
	public VoteBean() {
		
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void vote()
	{
		if(user.getStatus()==0) {
		try(CandidateDao cd = new CandidateDaoImpl())
		{
			int cnt = cd.incrementVote(candidateId);
			if(cnt == 1)
			{
				try(UserDao ud = new UserDaoImpl())
				{
					cnt = ud.updateStatus(user.getId(), true);
					if(cnt==1)
						this.message = "Your Vote Successfully ";
					else
						this.message = "Some error occured , immediately contact support";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
			this.message = "You have already voted";
		}
	}
}

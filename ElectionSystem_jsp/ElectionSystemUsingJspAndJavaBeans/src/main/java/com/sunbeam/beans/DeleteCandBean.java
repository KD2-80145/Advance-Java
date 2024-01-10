package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandBean {
	int id;
	String message;
	public DeleteCandBean() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void delete()
	{
		try(CandidateDao cd = new CandidateDaoImpl())
		{
			int cnt = cd.deleteById(id);
			this.message = "Deleted Candidates : " + cnt ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}

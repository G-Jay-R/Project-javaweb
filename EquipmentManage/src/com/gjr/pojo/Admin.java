package com.gjr.pojo;

public class Admin {
	private String aname;
	private String apwd;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((apwd == null) ? 0 : apwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (apwd == null) {
			if (other.apwd != null)
				return false;
		} else if (!apwd.equals(other.apwd))
			return false;
		return true;
	}
	public Admin(String aname, String apwd) {
		super();
		this.aname = aname;
		this.apwd = apwd;
	}
	public Admin() {
		super();
	}

}

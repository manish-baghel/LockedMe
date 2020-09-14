package com.lockedme.model;

public class LockedMeFile {
	
	private int id;			// Id of file
	private String name;	// Name of file
	private String ext; 	// extension
	private long ts;		// timestamp
	private long size;		// filesize
	
	
	
	public LockedMeFile() {
		// Empty Constructor
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
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "LockedMeFile [id=" + id + ", name=" + name + ", ext=" + ext + ", ts=" + ts + ", size=" + size + "]";
	}
	

}

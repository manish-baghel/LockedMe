package com.lockedme.service;

import java.util.List;

import com.lockedme.exception.LockedMeException;
import com.lockedme.model.LockedMeFile;

public interface LockedMeFileService {
	
	public LockedMeFile addFile(LockedMeFile file) throws LockedMeException;
	public LockedMeFile deleteFileById(int id) throws LockedMeException;
	public LockedMeFile deleteFileByName(String name) throws LockedMeException;
	public LockedMeFile searchFileByName(String name) throws LockedMeException;
	public LockedMeFile searchFileById(int id) throws LockedMeException;
	
	public List<LockedMeFile> getAllFiles() throws LockedMeException;
	public List<LockedMeFile> getFilesByext(String ext) throws LockedMeException;
}

package com.lockedme.service.impl;

import java.util.List;

import com.lockedme.dao.LockedMeFileDAO;
import com.lockedme.dao.impl.LockedMeFileDAOImpl;
import com.lockedme.exception.LockedMeException;
import com.lockedme.model.LockedMeFile;
import com.lockedme.service.LockedMeFileService;

public class LockedMeFileServiceImpl implements LockedMeFileService{
	
	private LockedMeFileDAO dao = new LockedMeFileDAOImpl();
	private String src = "../../dir1/";
	private String dest = "../../dir2/";

	@Override
	public LockedMeFile addFile(LockedMeFile file) throws LockedMeException {
		if(!isValidName(file.getName())) {
			throw new LockedMeException("Entered file name "+file.getName()+" is Invalid");
		}else if(!isValidSize(file.getSize())) {
			throw new LockedMeException("Entered file size "+file.getSize()+" is Invalid");
		}
		return dao.addFile(file);
	}


	@Override
	public LockedMeFile searchFileByName(String name) throws LockedMeException {
		if(!isValidName(name))
			throw new LockedMeException("Invalid name: "+name);
		return dao.searchFileByName(name);
	}

	@Override
	public LockedMeFile searchFileById(int id) throws LockedMeException {
		if(!isValidId(id))
			throw new LockedMeException("Invalid id: "+id);
		return dao.searchFileById(id);
	}

	@Override
	public LockedMeFile deleteFileById(int id) throws LockedMeException {
		if(!isValidId(id))
			throw new LockedMeException("Invalid id: "+id);
		return dao.deleteFileById(id);
	}

	@Override
	public LockedMeFile deleteFileByName(String name) throws LockedMeException {
		if(!isValidName(name))
			throw new LockedMeException("Invalid name: "+name);
		return dao.deleteFileByName(name);
	}
	@Override
	public List<LockedMeFile> getAllFiles() throws LockedMeException {
		return dao.getAllFiles();
	}

	@Override
	public List<LockedMeFile> getFilesByext(String ext) throws LockedMeException {
		return dao.getFilesByExt(ext);
	}

	private boolean isValidName(String name) {
		return name.trim().matches("[a-zA-Z._0-9]{1,20}");
	}
	
	private boolean isValidId(int id) {
		return !(id<0 && id>100000);
	}
	
	private boolean isValidSize(long size) {
		return true;
	}


}

package com.lockedme.service.impl;

import java.util.List;

import com.lockedme.dao.LockedMeFileDAO;
import com.lockedme.dao.impl.LockedMeFileDAOImpl;
import com.lockedme.exception.LockedMeException;
import com.lockedme.model.LockedMeFile;
import com.lockedme.service.LockedMeFileService;

public class LockedMeFileServiceImpl implements LockedMeFileService {

	private LockedMeFileDAO dao = new LockedMeFileDAOImpl();

	/**
	 * Experimental code - for adding more functionality like transferring files
	 * from one dir to another. private String src = "../../dir1/"; private String
	 * dest = "../../dir2/";
	 */

	/**
	 * Service Method for adding File - uses DAO Impl addFile method.
	 * 
	 * @param file new File to add.
	 * @return the newly added file.
	 * @throws LockedMeException if fields fail vailidity check.
	 */

	@Override
	public LockedMeFile addFile(LockedMeFile file) throws LockedMeException {
		if (!isValidName(file.getName())) {
			throw new LockedMeException("Entered file name " + file.getName() + " is Invalid");
		} else if (!isValidSize(file.getSize())) {
			throw new LockedMeException("Entered file size " + file.getSize() + " is Invalid");
		}
		return dao.addFile(file);
	}

	/**
	 * Service Method for searching a File - uses DAO Impl SearchFileByName method.
	 * 
	 * @param name name field for searching a file.
	 * @return file if found.
	 * @throws LockedMeException if file not found with given name.
	 */

	@Override
	public LockedMeFile searchFileByName(String name) throws LockedMeException {
		if (!isValidName(name))
			throw new LockedMeException("Invalid name: " + name);
		return dao.searchFileByName(name);
	}

	/**
	 * Service Method for searching a File - uses DAO Impl SearchFileById method.
	 * 
	 * @param id id field for searching a file.
	 * @return file if found.
	 * @throws LockedMeException if file not found with given id.
	 */
	@Override
	public LockedMeFile searchFileById(int id) throws LockedMeException {
		if (!isValidId(id))
			throw new LockedMeException("Invalid id: " + id);
		return dao.searchFileById(id);
	}
	
	/**
	 * Service Method for deleting a File - uses DAO Impl DeleteFileById method.
	 * 
	 * @param id id field for deleting a file.
	 * @return the deleted file.
	 * @throws LockedMeException if file not found with given id.
	 */

	@Override
	public LockedMeFile deleteFileById(int id) throws LockedMeException {
		if (!isValidId(id))
			throw new LockedMeException("Invalid id: " + id);
		return dao.deleteFileById(id);
	}
	
	/**
	 * Service Method for deleting a File - uses DAO Impl DeleteFileByName method.
	 * 
	 * @param name name field for deleting a file.
	 * @return the deleted file.
	 * @throws LockedMeException if file not found with given name.
	 */

	@Override
	public LockedMeFile deleteFileByName(String name) throws LockedMeException {
		if (!isValidName(name))
			throw new LockedMeException("Invalid name: " + name);
		return dao.deleteFileByName(name);
	}
	
	/**
	 * Service Method for returning all Files - uses DAO Impl getAllFiles method.
	 * 
	 * @param none
	 * @return ArrayList containing all files.
	 * @throws LockedMeException if file maps are empty.
	 */

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
		return !(id < 0 && id > 100000);
	}

	private boolean isValidSize(long size) {
		return true;
	}

}

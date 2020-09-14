package com.lockedme.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.lockedme.dao.LockedMeFileDAO;
import com.lockedme.exception.LockedMeException;
import com.lockedme.model.LockedMeFile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LockedMeFileDAOImpl implements LockedMeFileDAO{

	private static Map<Integer, LockedMeFile> idFileMap = new HashMap<>();
	private static Map<String, LockedMeFile> nameFileMap = new HashMap<>();
	
	private static AtomicInteger counter = new AtomicInteger();
	
	@Override
	public LockedMeFile addFile(LockedMeFile file) throws LockedMeException {
		file.setId(counter.incrementAndGet());
		idFileMap.put(file.getId(), file);
		nameFileMap.put(file.getName(), file);
		return file;
	}

	@Override
	public LockedMeFile deleteFileByName(String name) throws LockedMeException {
		if(nameFileMap.containsKey(name)) {
			LockedMeFile file = nameFileMap.get(name);
			nameFileMap.remove(name);
			idFileMap.remove(file.getId());
			return file;
		}else {
			throw new LockedMeException("File does not exist with name "+name);
		}
	}

	@Override
	public LockedMeFile deleteFileById(int id) throws LockedMeException {
		if(idFileMap.containsKey(id)) {
			LockedMeFile file = idFileMap.get(id);
			idFileMap.remove(id);
			nameFileMap.remove(file.getName());
			return file;
		}else {
			throw new LockedMeException("File does not exist with id "+id);
		}
	}
	
	
	@Override
	public LockedMeFile searchFileByName(String name) throws LockedMeException {
		if(nameFileMap.containsKey(name)) {
			return nameFileMap.get(name);
		}else {
			throw new LockedMeException("File does not exist with name "+name);
		}
	}

	@Override
	public LockedMeFile searchFileById(int id) throws LockedMeException {
		if(idFileMap.containsKey(id)) {
			return idFileMap.get(id);
		}else {
			throw new LockedMeException("File does not exist with id "+id);
		}
	}

	@Override
	public List<LockedMeFile> getAllFiles() throws LockedMeException {
		if(idFileMap.size() == 0)
			throw new LockedMeException("No files found in the directory. Please add some file ");
		return new ArrayList<>(idFileMap.values());
	}

	@Override
	public List<LockedMeFile> getFilesByExt(String ext) throws LockedMeException {
		List<LockedMeFile> fileList = idFileMap.values().stream().filter(f -> f.getExt() == ext).collect(Collectors.toList());
		if(fileList.size() == 0)
			throw new LockedMeException("No files found with ext "+ext);
		return fileList;
		
	}



}

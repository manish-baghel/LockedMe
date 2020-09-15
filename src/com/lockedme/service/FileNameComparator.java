package com.lockedme.service;

import java.util.Comparator;

import com.lockedme.model.LockedMeFile;

public class FileNameComparator implements Comparator<LockedMeFile> {

	@Override
	public int compare(LockedMeFile o1, LockedMeFile o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

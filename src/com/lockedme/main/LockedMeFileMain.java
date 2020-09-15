package com.lockedme.main;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.lockedme.exception.LockedMeException;
import com.lockedme.model.LockedMeFile;
import com.lockedme.service.FileNameComparator;
import com.lockedme.service.LockedMeFileService;
import com.lockedme.service.impl.LockedMeFileServiceImpl;

public class LockedMeFileMain {
	public static void main(String[] args) {
		System.out.println("Welcome to LockedMe.com - Prototype");
		System.out.println("============================================================");

		Scanner sc = new Scanner(System.in);
		int ch = 0;

		LockedMeFileService service = new LockedMeFileServiceImpl();

		do {

			System.out.println("\n\n Locked Me File Prototype");
			System.out.println("========================================");
			System.out.println("1) Get all files (ascending order of name)");
			System.out.println("2) Perform File Operations (Add, Search and Delete)");
			System.out.println("3) Exit the application");
			System.out.println("Please enter an appropriate choice (1-3)");

			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}

			switch (ch) {
			case 1:
				try {
					List<LockedMeFile> fileList = service.getAllFiles();
					Collections.sort(fileList,new FileNameComparator());
					if (fileList != null && fileList.size() > 0) {
						System.out.println("Found " + fileList.size() + " files......");
						for (LockedMeFile f : fileList) {
							System.out.println(f);
						}
					}
				} catch (LockedMeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				do {
					System.out.println("Add, delete or search files..........");
					System.out.println("=======================================");
					System.out.println("1) Add a file");
					System.out.println("2) Search a file by Id");
					System.out.println("3) Search a file by Name");
					System.out.println("4) Delete a file by Id");
					System.out.println("5) Delete a file by Name");
					System.out.println("6) Exit to Main Menu");
					System.out.println("Please enter an appropriate choice (1-6)");

					try {
						ch = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
						System.out.println(e.getMessage());
					}

					switch (ch) {
					case 1:
						System.out.println("Enter file details.......");
						LockedMeFile file = new LockedMeFile();
						System.out.print("Enter file name: ");
						file.setName(sc.nextLine());
						System.out.print("\nEnter file extension: ");
						file.setExt(sc.nextLine());
						file.setTs(System.currentTimeMillis());
						file.setSize(10000);
						try {
							service.addFile(file);
						} catch (LockedMeException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						System.out.println("Search By Id.....");
						System.out.print("Enter file id: ");
						int id = 0;
						try {
							id = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println(e.getMessage());
						}
						System.out.println();
						try {
							LockedMeFile f = service.searchFileById(id);
							System.out.println(f);
						} catch (LockedMeException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						System.out.println("Search By Name.....");
						System.out.print("Enter file name: ");
						String n = sc.nextLine();
						System.out.println();
						try {
							LockedMeFile f = service.searchFileByName(n);
							System.out.println(f);
						} catch (LockedMeException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						System.out.println("Delete a file By Id......");
						System.out.print("Enter file id: ");
						int i = 0;
						try {
							i = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							System.out.println(e.getMessage());
						}
						try {
							LockedMeFile f = service.deleteFileById(i);
							System.out.println("\nFile deleted with details: " + f);
						} catch (LockedMeException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println("Delete a file By Name......");
						System.out.print("Enter file name: ");
						String nm = sc.nextLine();
						try {
							LockedMeFile f = service.deleteFileByName(nm);
							System.out.println("\nFile deleted with details: " + f);
						} catch (LockedMeException e) {
							System.out.println(e.getMessage());
						}
						break;
					default:
						System.out.println("Entered choice is invalid only no's between 1-6 are allowed");
						break;
					}
				} while (ch != 6);
				break;
			case 3:
				System.out.println("Thank you for using Locked Me File Prototype - @author:manish-baghel");
				break;
			default:
				System.out.println("Entered choice is invalid only no's between 1-3 are allowed");
				break;
			}

		} while (ch != 3);

	}

}

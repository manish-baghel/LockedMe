#LockedMe - Simplilearn Phase I Assessment

A prototype application implementing an file locker idea.

##Technologies Used

| Java | 1.8 |
| ------- | ------- |
| Editor/IDE  |  Eclipse with Vrapper Vim Plugin  |

## File Structure
```
.
├── README.md
└── src
    └── com
        └── lockedme
            ├── dao
            │   ├── LockedMeFileDAO.java
            │   └── impl
            │       └── LockedMeFileDAOImpl.java
            ├── exception
            │   └── LockedMeException.java
            ├── main
            │   └── LockedMeFileMain.java
            ├── model
            │   └── LockedMeFile.java
            └── service
                ├── FileNameComparator.java
                ├── LockedMeFileService.java
                └── impl
                    └── LockedMeFileServiceImpl.java

```

## Project Structure

This project utilizes DAO and Service Model pattern of a Java Application.

##Hierarchy For All Packages
###Package Hierarchies:

    com.lockedme.dao, com.lockedme.dao.impl, com.lockedme.exception, com.lockedme.main, com.lockedme.model, com.lockedme.service, com.lockedme.service.impl 

###Class Hierarchy

    java.lang.Object
        com.lockedme.service.FileNameComparator (implements java.util.Comparator<T>)
        com.lockedme.model.LockedMeFile
        com.lockedme.dao.impl.LockedMeFileDAOImpl (implements com.lockedme.dao.LockedMeFileDAO)
        com.lockedme.main.LockedMeFileMain
        com.lockedme.service.impl.LockedMeFileServiceImpl (implements com.lockedme.service.LockedMeFileService)
        java.lang.Throwable (implements java.io.Serializable)
            java.lang.Exception
                com.lockedme.exception.LockedMeException

###Interface Hierarchy

    com.lockedme.dao.LockedMeFileDAO
    com.lockedme.service.LockedMeFileService


## Docs
For Complete Docs please use docs folder in the repository.




//package com.solvestack.service;
//
//import com.solvestack.model.Folder;
//import com.solvestack.repository.FolderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class FolderService {
//
//    @Autowired
//    private FolderRepository folderRepository;
//
//    public List<Folder> getAllFolders() {
//        return folderRepository.findAll();
//    }
//
//    public Folder createFolder(Folder folder) {
//        return folderRepository.save(folder);
//    }
//
//    public Folder updateFolder(String id, Folder folder) {
//        folder.setId(id);
//        return folderRepository.save(folder);
//    }
//
//    public void deleteFolder(String id) {
//        folderRepository.deleteById(id);
//    }
//
//    public Folder toggleStar(String id) {
//        Folder folder = folderRepository.findById(id).orElseThrow(() -> new RuntimeException("Folder not found"));
//        folder.setStarred(!folder.isStarred());
//        return folderRepository.save(folder);
//    }
//}
package com.solvestack.service;

import com.solvestack.model.Folder;
import com.solvestack.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    public List<Folder> getAllFolders(String userId) {
        return folderRepository.findByUserId(userId);
    }

    public Folder createFolder(Folder folder, String userId) {
        folder.setUserId(userId);
        return folderRepository.save(folder);
    }

    public Folder updateFolder(String id, Folder folder, String userId) {
        folder.setId(id);
        folder.setUserId(userId);
        return folderRepository.save(folder);
    }

    public void deleteFolder(String id) {
        folderRepository.deleteById(id);
    }

    public Folder toggleStar(String id) {
        Folder folder = folderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Folder not found"));
        folder.setStarred(!folder.isStarred());
        return folderRepository.save(folder);
    }
}
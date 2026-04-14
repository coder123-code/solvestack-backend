//package com.solvestack.controller;
//
//import com.solvestack.model.Folder;
//import com.solvestack.service.FolderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/folders")
//@CrossOrigin(origins = "http://localhost:3000")
//public class FolderController {
//
//    @Autowired
//    private FolderService folderService;
//
//    @GetMapping
//    public ResponseEntity<List<Folder>> getAllFolders() {
//        return ResponseEntity.ok(folderService.getAllFolders());
//    }
//
//    @PostMapping
//    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(folderService.createFolder(folder));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Folder> updateFolder(@PathVariable String id, @RequestBody Folder folder) {
//        return ResponseEntity.ok(folderService.updateFolder(id, folder));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFolder(@PathVariable String id) {
//        folderService.deleteFolder(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PatchMapping("/{id}/star")
//    public ResponseEntity<Folder> toggleStar(@PathVariable String id) {
//        return ResponseEntity.ok(folderService.toggleStar(id));
//    }
//}
package com.solvestack.controller;

import com.solvestack.model.Folder;
import com.solvestack.service.FolderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/folders")
// @CrossOrigin(origins = "http://localhost:3000")
    @CrossOrigin(origins = {"http://localhost:3000", "https://solvetrack-frontend.vercel.app"})
public class FolderController {

    @Autowired
    private FolderService folderService;

    @GetMapping
    public ResponseEntity<List<Folder>> getAllFolders(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return ResponseEntity.ok(folderService.getAllFolders(userId));
    }

    @PostMapping
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return ResponseEntity.status(HttpStatus.CREATED).body(folderService.createFolder(folder, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable String id, @RequestBody Folder folder, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return ResponseEntity.ok(folderService.updateFolder(id, folder, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFolder(@PathVariable String id) {
        folderService.deleteFolder(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/star")
    public ResponseEntity<Folder> toggleStar(@PathVariable String id) {
        return ResponseEntity.ok(folderService.toggleStar(id));
    }
}

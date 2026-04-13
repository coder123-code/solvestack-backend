//package com.solvestack.model;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import java.time.LocalDateTime;
//
//@Data
//@Document(collection = "problems")
//public class Problem {
//    @Id
//    private String id;
//    private String questionName;
//    private String description;
//    private String link;
//    private String difficulty; // Easy, Medium, Hard
//    private String note;
//    private boolean solved;
//    private boolean revise;
//    private String programmingLanguage;
//    private String codeSnippet;
//    private String imageUrl;
//    private String folderId;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//}
package com.solvestack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "problems")
public class Problem {
    @Id
    private String id;
    private String userId;
    private String questionName;
    private String description;
    private String link;
    private String difficulty;
    private String note;
    private boolean solved;
    private boolean revise;
    private String programmingLanguage;
    private String codeSnippet;
    private String imageUrl;
    private String folderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
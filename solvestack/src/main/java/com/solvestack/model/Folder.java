//package com.solvestack.model;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Document(collection = "folders")
//public class Folder {
//    @Id
//    private String id;
//    private String name;
//    private List<String> problemIds = new ArrayList<>();
//    private boolean starred;
//    private String color;
//}
package com.solvestack.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "folders")
public class Folder {
    @Id
    private String id;
    private String userId;
    private String name;
    private List<String> problemIds = new ArrayList<>();
    private boolean starred;
    private String color;
}
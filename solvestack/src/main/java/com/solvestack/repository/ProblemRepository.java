//package com.solvestack.repository;
//
//import com.solvestack.model.Problem;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface ProblemRepository extends MongoRepository<Problem, String> {
//    List<Problem> findByDifficulty(String difficulty);
//    List<Problem> findBySolved(boolean solved);
//    List<Problem> findByRevise(boolean revise);
//}

package com.solvestack.repository;

import com.solvestack.model.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProblemRepository extends MongoRepository<Problem, String> {
    List<Problem> findByUserId(String userId);
    List<Problem> findByUserIdAndDifficulty(String userId, String difficulty);
    List<Problem> findByUserIdAndSolved(String userId, boolean solved);
}
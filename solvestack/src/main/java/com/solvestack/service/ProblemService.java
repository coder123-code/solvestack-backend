//package com.solvestack.service;
//
//import com.solvestack.model.Problem;
//import com.solvestack.repository.ProblemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class ProblemService {
//
//    @Autowired
//    private ProblemRepository problemRepository;
//
//    public List<Problem> getAllProblems() {
//        return problemRepository.findAll();
//    }
//
//    public Problem getProblemById(String id) {
//        return problemRepository.findById(id).orElseThrow(() -> new RuntimeException("Problem not found"));
//    }
//
//    public Problem createProblem(Problem problem) {
//        problem.setCreatedAt(LocalDateTime.now());
//        problem.setUpdatedAt(LocalDateTime.now());
//        return problemRepository.save(problem);
//    }
//
//    public Problem updateProblem(String id, Problem problem) {
//        problem.setId(id);
//        problem.setUpdatedAt(LocalDateTime.now());
//        return problemRepository.save(problem);
//    }
//
//    public void deleteProblem(String id) {
//        problemRepository.deleteById(id);
//    }
//
//    public Problem toggleSolved(String id) {
//        Problem problem = getProblemById(id);
//        problem.setSolved(!problem.isSolved());
//        problem.setUpdatedAt(LocalDateTime.now());
//        return problemRepository.save(problem);
//    }
//
//    public Problem toggleRevise(String id) {
//        Problem problem = getProblemById(id);
//        problem.setRevise(!problem.isRevise());
//        problem.setUpdatedAt(LocalDateTime.now());
//        return problemRepository.save(problem);
//    }
//
//    public List<Problem> getProblemsByDifficulty(String difficulty) {
//        return problemRepository.findByDifficulty(difficulty);
//    }
//
//    public List<Problem> getSolvedProblems() {
//        return problemRepository.findBySolved(true);
//    }
//}

package com.solvestack.service;

import com.solvestack.model.Problem;
import com.solvestack.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    public List<Problem> getAllProblems(String userId) {
        return problemRepository.findByUserId(userId);
    }

    public Problem getProblemById(String id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found"));
    }

    public Problem createProblem(Problem problem, String userId) {
        problem.setUserId(userId);
        problem.setCreatedAt(LocalDateTime.now());
        problem.setUpdatedAt(LocalDateTime.now());
        return problemRepository.save(problem);
    }

    public Problem updateProblem(String id, Problem problem, String userId) {
        problem.setId(id);
        problem.setUserId(userId);
        problem.setUpdatedAt(LocalDateTime.now());
        return problemRepository.save(problem);
    }

    public void deleteProblem(String id) {
        problemRepository.deleteById(id);
    }
}
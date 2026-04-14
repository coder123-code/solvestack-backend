//package com.solvestack.controller;
//
//import com.solvestack.model.Problem;
//import com.solvestack.service.ProblemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/problems")
//@CrossOrigin(origins = "http://localhost:3000")
//public class ProblemController {
//
//    @Autowired
//    private ProblemService problemService;
//
//    @GetMapping
//    public ResponseEntity<List<Problem>> getAllProblems() {
//        return ResponseEntity.ok(problemService.getAllProblems());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Problem> getProblemById(@PathVariable String id) {
//        return ResponseEntity.ok(problemService.getProblemById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(problemService.createProblem(problem));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Problem> updateProblem(@PathVariable String id, @RequestBody Problem problem) {
//        return ResponseEntity.ok(problemService.updateProblem(id, problem));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProblem(@PathVariable String id) {
//        problemService.deleteProblem(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PatchMapping("/{id}/toggle-solved")
//    public ResponseEntity<Problem> toggleSolved(@PathVariable String id) {
//        return ResponseEntity.ok(problemService.toggleSolved(id));
//    }
//
//    @PatchMapping("/{id}/toggle-revise")
//    public ResponseEntity<Problem> toggleRevise(@PathVariable String id) {
//        return ResponseEntity.ok(problemService.toggleRevise(id));
//    }
//
//    @GetMapping("/difficulty/{difficulty}")
//    public ResponseEntity<List<Problem>> getByDifficulty(@PathVariable String difficulty) {
//        return ResponseEntity.ok(problemService.getProblemsByDifficulty(difficulty));
//    }
//
//    @GetMapping("/solved")
//    public ResponseEntity<List<Problem>> getSolvedProblems() {
//        return ResponseEntity.ok(problemService.getSolvedProblems());
//    }
//}

package com.solvestack.controller;

import com.solvestack.model.Problem;
import com.solvestack.service.ProblemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/problems")
// @CrossOrigin(origins = "http://localhost:3000")
    @CrossOrigin(origins = {"http://localhost:3000", "https://solvetrack-frontend.vercel.app"})
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping
    public ResponseEntity<List<Problem>> getAllProblems(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return ResponseEntity.ok(problemService.getAllProblems(userId));
    }

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return ResponseEntity.status(HttpStatus.CREATED).body(problemService.createProblem(problem, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Problem> updateProblem(@PathVariable String id, @RequestBody Problem problem, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return ResponseEntity.ok(problemService.updateProblem(id, problem, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable String id) {
        problemService.deleteProblem(id);
        return ResponseEntity.noContent().build();
    }
}

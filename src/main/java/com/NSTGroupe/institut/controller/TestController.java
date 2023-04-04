package com.NSTGroupe.institut.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('PROFESSOR') or hasRole('STUDENT')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/prof")
  @PreAuthorize("hasRole('MODERATOR')")
  public String professorAccess() {
    return "Professor Board.";
  }

  @GetMapping("/student")
  @PreAuthorize("hasRole('STUDENT')")
  public String studentAccess() {
    return "StudentBoard.";
  }
}

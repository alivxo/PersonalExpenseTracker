package com.expense.tracker.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/profile")
@CrossOrigin
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class ProfileController {











}

package com.cbl.app.account.controller;

import com.cbl.app.account.util.UrlUtility;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.cbl.app.account.config.appconfig.AppConfigProperty;


@RestController
@RequiredArgsConstructor
@RequestMapping(UrlUtility.DUMMY_DASHBOARD_CONTROLLER)
public class DummyDashboardController {
    private static final Logger log = LoggerFactory.getLogger("dashboardLogger");

    private final AppConfigProperty appConfigProperty;

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/welcome-message")
    public ResponseEntity<String> getFirstWelcomeMessage() {
        return ResponseEntity.ok("Welcome to the JWT :" + "with scope:");
    }

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/manager-message")
    public ResponseEntity<String> getManagerData() {
        log.info("TestValue is : {}", appConfigProperty.getTestValue());
        return ResponseEntity.ok("Manager::" + "Welcome to the [city-statement-app-account-service]"+ appConfigProperty.getTestValue());

    }

    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PostMapping("/admin-message")
    public ResponseEntity<String> getAdminData(@RequestParam("message") String message) {
        return ResponseEntity.ok("Admin::" + " has this message:" + message);
    }
}

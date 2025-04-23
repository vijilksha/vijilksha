package com.cts.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cts.training.feign.AuthorisationClient;
import com.cts.training.model.TimeEntry;
import com.cts.training.service.TimeEntryService;
import com.cts.training.dto.SwipeRequest;
import com.cts.training.dto.TopUpRequest;

@RestController
@RequestMapping("/api/time")
public class TimeEntryController {

    @Autowired
    private TimeEntryService timeEntryService;

    @Autowired
    private AuthorisationClient authClient;

    @PostMapping("/swipe")
    public ResponseEntity<String> swipe(@RequestHeader(name = "Authorization") String token,
                                        @RequestBody SwipeRequest request) {
        if (authClient.validate(token)) {
            return timeEntryService.swipe(request);
            //return ResponseEntity.ok(message);
        } else {
            return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/topup")
    public ResponseEntity<String> topUp(@RequestHeader(name = "Authorization") String token,
                                        @RequestBody TopUpRequest request) {
        if (authClient.validate(token)) {
            return  timeEntryService.topUp(request);
            //return ResponseEntity.ok(message);
        } else {
            return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/approve/{entryId}")
    public ResponseEntity<String> approve(@RequestHeader(name = "Authorization") String token,
                                          @PathVariable Long entryId) {
        if (authClient.validate(token)) {
            return timeEntryService.approveEntry(entryId);
            //return message;
        } else {
            return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/entries")
    public ResponseEntity<?> approve(@RequestHeader(name = "Authorization") String token) {
        if (authClient.validate(token)) {
            return timeEntryService.getAllEntries(); // returns ResponseEntity<List<TimeEntry>>
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid token");
        }
    }

}

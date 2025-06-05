package com.gaming.algolabyrinth.controller;

import com.gaming.algolabyrinth.dto.SubmitSolutionRequestDTO;
import com.gaming.algolabyrinth.dto.SubmitSolutionResponseDTO;
import com.gaming.algolabyrinth.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/room")
public class SubmissionController {

    @Autowired private SubmissionService submissionService;

    public SubmitSolutionResponseDTO submitSolution(
            @PathVariable int level,
            @RequestBody SubmitSolutionRequestDTO request) throws Exception {
        return submissionService.submitSolution(request);
    }
}

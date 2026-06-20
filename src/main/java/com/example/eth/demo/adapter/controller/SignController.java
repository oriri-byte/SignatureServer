package com.example.eth.demo.adapter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.eth.demo.usecase.GenerateSignatureUseCase;
import com.example.eth.demo.usecase.dto.SignRequestDto;
import com.example.eth.demo.usecase.dto.SignResponseDto;

@RestController
@RequestMapping("/api/v1")
public class SignController {

    private final GenerateSignatureUseCase useCase;

    public SignController(GenerateSignatureUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/sign")
    public ResponseEntity<SignResponseDto> sign(@RequestBody SignRequestDto request) {
        SignResponseDto response = useCase.execute(request);
        return ResponseEntity.ok(response);
    }
}

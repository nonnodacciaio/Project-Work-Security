package com.generationitaly.incrediblestyle.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generationitaly.incrediblestyle.auth.Utente;

@RestController
@RequestMapping("/accountmanager")
public class AccountController {

    @GetMapping
    public String get() {
        return "<h1>Welcome account manager</h1>";
    }

    @GetMapping("/detail")
    public Utente test(@AuthenticationPrincipal Utente utente) {
        return utente;
    }
}
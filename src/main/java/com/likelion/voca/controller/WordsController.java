package com.likelion.voca.controller;

import com.likelion.voca.service.VocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {

    @Autowired
    private VocaService vocaService;


}

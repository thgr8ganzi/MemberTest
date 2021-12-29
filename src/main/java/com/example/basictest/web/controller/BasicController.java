package com.example.basictest.web.controller;

import com.example.basictest.domain.basicMember.BasicMember;
import com.example.basictest.web.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasicController {

    @Autowired
    BasicService basicService;

//    정보 가져오기
    @GetMapping(value = "/getBasic", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BasicMember>> getBasic(){
        List<BasicMember> basicMembers = basicService.getBasic();
        return new ResponseEntity<List<BasicMember>>(basicMembers, HttpStatus.OK);
    }

//    정보입력
    @PostMapping(value = "/insertBasic", produces = "application/json; charset=utf-8")
    public ResponseEntity<BasicMember> insertBasic(BasicMember basicMember){
        return new ResponseEntity<BasicMember>(basicService.insertBasic(basicMember), HttpStatus.OK);
    }

//    정보수정
    @PutMapping(value = "/update/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<BasicMember> updateBasic(@PathVariable("id") Long id, BasicMember basicMember){
        basicService.update(id, basicMember);
        return new ResponseEntity<BasicMember>(basicMember, HttpStatus.OK);
    }

//    정보삭제
    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteBasic(@PathVariable("id") Long id){
        basicService.deleteBasic(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}















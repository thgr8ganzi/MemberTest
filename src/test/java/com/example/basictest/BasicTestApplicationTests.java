package com.example.basictest;

import com.example.basictest.domain.basicMember.BasicMember;
import com.example.basictest.domain.basicMember.BasicMemberRepository;
import com.example.basictest.web.service.BasicService;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BasicTestApplicationTests {


    @Autowired
    BasicMemberRepository memberRepository;

    @Autowired
    BasicService basicService;

//    테스트 청소
    @After
    public void cleanup(){
        memberRepository.deleteAll();
    }

//    정보 가져오기
    @Test
    public void 가져오기(){
        List<BasicMember> list = basicService.getBasic();
    }

//    정보 입력
    @Test
    public void 정보입력(){
        BasicMember basicMember = new BasicMember();
        basicMember.setId(1L);
        basicMember.setPw("pw");
        basicMember.setName("name");

        basicService.insertBasic(basicMember);


    }

//    정보수정
    @Test
    public void 정보수정(){
        BasicMember basicMember = new BasicMember();
        Long id = Long.valueOf(2);

        basicMember.setPw("pw");
        basicMember.setName("name");
        basicService.update(id, basicMember);
    }

//    정보삭제
    @Test
    public void 정보삭제(){

        basicService.deleteBasic(1L);
        
    }

}















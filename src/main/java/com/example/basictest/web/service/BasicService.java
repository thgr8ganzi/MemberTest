package com.example.basictest.web.service;

import com.example.basictest.domain.basicMember.BasicMember;
import com.example.basictest.domain.basicMember.BasicMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BasicService {

    @Autowired
    BasicMemberRepository memberRepository;

    //    정보가져오기
    @Transactional
    public List<BasicMember> getBasic() {
        List<BasicMember> basicMembers = memberRepository.findAll();
        return basicMembers;
    }

//    정보입력
    @Transactional
    public BasicMember insertBasic(BasicMember basicMember) {
        memberRepository.save(basicMember);
        return basicMember;
    }

//    정보수정
    @Transactional
    public void update(Long id, BasicMember basicMember) {
        memberRepository.save(basicMember);
    }

//    정보삭제
    @Transactional
    public void deleteBasic(Long id) {
        memberRepository.deleteAllById(id);
    }
}

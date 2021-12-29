package com.example.basictest.domain.basicMember;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicMemberRepository extends JpaRepository<BasicMember, Long> {
    void deleteAllById(Long id);
}
package com.pet.sitter.member.controller;

import com.pet.sitter.common.entity.Member;
import com.pet.sitter.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RequestMapping("/member")
@RequiredArgsConstructor
@Controller
public class FindMemberIdController {

    private final MemberRepository memberRepository;

    @GetMapping("/memberid")
    public ResponseEntity<String> getEmailByPhoneNumber(@RequestParam String phone) {
        Optional<Member> memberOptional = memberRepository.findByPhone(phone);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            String memberId = member.getMemberId();
            return ResponseEntity.ok(memberId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/pw")
    public ResponseEntity<String> getPassword(@RequestParam String memberId) {
        return ResponseEntity.ok("서버에서 받은 아이디: " + memberId);
    }
}
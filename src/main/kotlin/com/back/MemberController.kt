package com.back

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(private val memberRepository: MemberRepository) {
    @GetMapping("/members")
    fun members(): List<Member> = memberRepository.findAll()
}

@Configuration
class MemberDataInit(private val memberRepository: MemberRepository) {
    @Bean
    fun initMembers() = ApplicationRunner {
        if (memberRepository.count() == 0L) {
            memberRepository.saveAll(listOf(
                Member(name = "Alice", email = "alice@example.com"),
                Member(name = "Bob", email = "bob@example.com"),
                Member(name = "Charlie", email = "charlie@example.com"),
            ))
        }
    }
}

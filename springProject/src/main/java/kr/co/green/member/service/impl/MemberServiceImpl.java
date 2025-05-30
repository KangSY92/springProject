package kr.co.green.member.service.impl;

import org.springframework.stereotype.Service;

import kr.co.green.member.dto.MemberDTO;
import kr.co.green.member.mapper.MemberMapper;
import kr.co.green.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;

	@Override
	public int register(MemberDTO memeberDTO) {
		return memberMapper.register(memeberDTO);
		
	}
	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		return memberMapper.login(memberDTO);
	}

}

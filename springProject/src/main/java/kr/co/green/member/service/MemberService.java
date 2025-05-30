package kr.co.green.member.service;

import kr.co.green.member.dto.MemberDTO;

public interface MemberService {
	public int register(MemberDTO memberDTO);

	public MemberDTO login(MemberDTO memberDTO);
}

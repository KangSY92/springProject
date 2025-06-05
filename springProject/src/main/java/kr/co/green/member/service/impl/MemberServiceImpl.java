package kr.co.green.member.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.green.member.dto.MemberDTO;
import kr.co.green.member.mapper.MemberMapper;
import kr.co.green.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;

	@Override
	public int register(MemberDTO memberDTO) {
		String encodePassword = passwordEncoder.encode(memberDTO.getPassword());
		memberDTO.setPassword(encodePassword);
		
		return memberMapper.register(memberDTO);
		
	}
	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		// 1. 사용가가 입력한 id가 일치하는 데이터가 있냐? 있으면 MemberDTO로 받기
		MemberDTO result = memberMapper.login(memberDTO);
		
		// 2. DB에서 조회된 password와 사용자가 입력한 password가 일치하냐?
		//             (암호화된 데이터)         (평문 데이터)
		
		// 3.                     (사용자가 입력한 비밀번호)     (DB에 저장된 암호화 된 비밀번호)
		if(passwordEncoder.matches(memberDTO.getPassword(), result.getPassword())){
			return result;
		}
		
		return null;
	}

}

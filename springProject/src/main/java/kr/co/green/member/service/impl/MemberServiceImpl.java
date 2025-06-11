package kr.co.green.member.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.green.member.dto.request.LoginReqDTO;
import kr.co.green.member.dto.request.RegisterReqDTO;
import kr.co.green.member.dto.response.LoginResDTO;
import kr.co.green.member.model.mapper.MemberMapper;
import kr.co.green.member.model.vo.MemberVO;
import kr.co.green.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;

	@Override
	public int register(RegisterReqDTO registerReqDTO) {
//		try {
			String encodePassword = passwordEncoder.encode(registerReqDTO.getPassword());
//			throw new MyBatisSystemException("asdf", null);
//			
			registerReqDTO.setPassword(encodePassword);
//			
//		} catch(MyBatisSystemException e) {
//			throw new MemberException("회원가입이 실패했습니다.", HttpStatus.BAD_REQUEST, "member/register");
//			
//		}
		
		return memberMapper.register(MemberVO.fromRegisterReqDTO(registerReqDTO));
		
	}
	@Override
	public LoginResDTO login(LoginReqDTO loginReqDTO) {
		// 1. 사용가가 입력한 id가 일치하는 데이터가 있냐? 있으면 MemberDTO로 받기
		MemberVO memberVO = MemberVO.fromLoginReqDTO(loginReqDTO);
		MemberVO result = memberMapper.login(memberVO);
		
		// 2. DB에서 조회된 password와 사용자가 입력한 password가 일치하냐?
		//             (암호화된 데이터)         (평문 데이터)
		
		// 3.                     (사용자가 입력한 비밀번호)     (DB에 저장된 암호화 된 비밀번호)
		if(passwordEncoder.matches(loginReqDTO.getPassword(), result.getPassword())){
			return LoginResDTO.fromMemberVO(memberVO);
		}
		
		return null;
	}

}

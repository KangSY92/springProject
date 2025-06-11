package kr.co.green.member.service;

import kr.co.green.member.dto.request.LoginReqDTO;
import kr.co.green.member.dto.request.RegisterReqDTO;
import kr.co.green.member.dto.response.LoginResDTO;

public interface MemberService {
	public int register(RegisterReqDTO registerReqDTO);

	public LoginResDTO login(LoginReqDTO loginReqDTO);
}

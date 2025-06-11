package kr.co.green.member.model.vo;

import kr.co.green.member.dto.request.LoginReqDTO;
import kr.co.green.member.dto.request.RegisterReqDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private int memberId;
	private String id;
	private String name;
	private String password;
	private String status;
	private String createdAt;
	private String updatedAt;
	
	public static MemberVO fromRegisterReqDTO(RegisterReqDTO registerReqDTO) {
		return new MemberVO().builder()
							 .id(registerReqDTO.getId())
							 .name(registerReqDTO.getName())
							 .password(registerReqDTO.getPassword())
							 .build();
		
	}
	
	public static MemberVO fromLoginReqDTO(LoginReqDTO loginReqDTO) {
		return new MemberVO().builder()
							 .id(loginReqDTO.getId())
							 .password(loginReqDTO.getPassword())
							 .build();
	}
	
}

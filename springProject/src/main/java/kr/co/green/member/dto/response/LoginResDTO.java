package kr.co.green.member.dto.response;

import kr.co.green.member.model.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 로그인 응답 DTO 입니다.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResDTO {

	private int memberId;
	private String id;
	private String name;
	private String status; 
	
	public static LoginResDTO fromMemberVO(MemberVO memberVO) {
		return new LoginResDTO(memberVO.getMemberId(),
							   memberVO.getId(),
							   memberVO.getName(),
							   memberVO.getStatus());
		
		
		
		
	}
	
}

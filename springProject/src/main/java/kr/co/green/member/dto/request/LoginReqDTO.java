package kr.co.green.member.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 로그인 요청 DTO 클래스 입니다.
 */

@Setter
@Getter
@NoArgsConstructor
public class LoginReqDTO {
	private String id;
	private String password;

}

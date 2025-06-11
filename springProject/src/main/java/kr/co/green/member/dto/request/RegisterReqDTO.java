package kr.co.green.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 회원가입 요청 DTO 클래스 입니다.
 * 
 * 이름과 아이디는 유효성을 검증합니다.
 */
@Setter
@Getter
@NoArgsConstructor
public class RegisterReqDTO {
	@NotBlank
	@Pattern(regexp = "^[가-힣]+$")
	private String name;
	
	@NotBlank(message="ID는 필수입력입니다.")
	@Size(min=4, max=30, message="ID는 4자 이상 30자 이하여야합니다.")
	private String id;
	

	private String password;

}

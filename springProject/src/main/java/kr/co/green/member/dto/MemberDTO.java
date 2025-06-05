package kr.co.green.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private int memberId;
	
	@NotBlank(message="ID는 필수입력입니다.")
	@Size(min=4, max=30, message="ID는 4자 이상 30자 이하여야합니다.")
	private String id;
	
	@NotBlank
	@Pattern(regexp = "^[가-힣]+$")
	private String name;
	private String password;
	private String confirmPassword;
	private String status;
	private String createdAt;
	private String updatedAt;
}

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
	
	private String id;
	

	private String name;
	private String password;
	private String confirmPassword;
	private String status;
	private String createdAt;
	private String updatedAt;
}

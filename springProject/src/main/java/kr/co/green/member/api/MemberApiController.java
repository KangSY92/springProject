package kr.co.green.member.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.green.member.dto.MemberDTO;

@RestController
public class MemberApiController {
	
	@GetMapping("/api/member/{id}")
	public ResponseEntity<MemberDTO> findMemberByName(@PathVariable("id") String id) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("강석영");
		memberDTO.setId(id);
		
		return new ResponseEntity<MemberDTO>(memberDTO, HttpStatus.OK);
		
	}

}

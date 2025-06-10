package kr.co.green.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import kr.co.green.member.dto.MemberDTO;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MemberRegisterTest {
	private MockMvc mockMvc;
	
	@Autowired
	public MemberRegisterTest(MockMvc mockMvc) {
		super();
		this.mockMvc = mockMvc;
	}
	
	
	/**
	 * 회원가입 성공 테스트 코드  
	 * @throws Exception 
	 */
	@Test
	public void registerSuccess() throws Exception {
		// 1. 회원가입 요청 데이터
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("짱구");
		memberDTO.setId("jjang9");
		memberDTO.setPassword("qwer1234");
		
		// 2.회원가입 요청
		ResultActions result = mockMvc.perform(post("/member/register")
				                               .servletPath("/member/register")
				                               .param("name", memberDTO.getName())
				                               .param("id", memberDTO.getId())
				                               .param("password", memberDTO.getPassword()));
		
		// 3. 기댓값 검증
		result.andExpect(status().is3xxRedirection())
			  .andExpect(view().name("redirect:/member/login/form"))
			  .andDo(print());
		
	}
	
	/**
	 * 회원가입 실패 테스트 코드
	 * @throws Exception 
	 */
	@Test
	public void registerFailValidationError() throws Exception {
		// 1. 회원가입 요청
		ResultActions result = mockMvc.perform(post("/member/register")
				                               .servletPath("/member/register")
				                               .param("name", "맹구")
				                               .param("id", "m9")
				                               .param("password", "qwer1234"));
		
		// 2.기댓값 검증
		result.andExpect(status().isOk())
			  .andExpect(view().name("member/register"))
			  .andDo(print());
		
		
		
	}
	

}

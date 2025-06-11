package kr.co.green.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.co.green.member.dto.request.LoginReqDTO;
import kr.co.green.member.model.vo.MemberVO;

@Mapper
public interface MemberMapper {
	int register(MemberVO memberVO);
	
	MemberVO login(MemberVO memberVO);

}

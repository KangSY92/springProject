package kr.co.green.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.co.green.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	int register(MemberDTO memberDTO);
	
	MemberDTO login(MemberDTO memberDTO);

}

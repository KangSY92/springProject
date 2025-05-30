package kr.co.green.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.green.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> getAllPosts();

}

package kr.co.green.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.dto.PageInfoDTO;
import kr.co.green.board.dto.SearchDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> getAllPosts(@Param("pi") PageInfoDTO pi);

	int getTotalCount(@Param("searchDTO") SearchDTO searchDTO);

}

package kr.co.green.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.dto.FileDTO;
import kr.co.green.board.dto.PageInfoDTO;
import kr.co.green.board.dto.SearchDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> getAllPosts(@Param("pi") PageInfoDTO pi,
								@Param("searchDTO") SearchDTO searchDTO);

	int getTotalCount(@Param("searchDTO") SearchDTO searchDTO);
	
	int create(@Param("boardDTO") BoardDTO baordDTO);
	
	BoardDTO detail(@Param("fbId") int fbId);
	
	int incrementViewCount(@Param("fbId") int fbId);

	int delete(@Param("fbId") int fbId);

	int edit(@Param("boardDTO") BoardDTO boardDTO);
	
	int createFile(@Param("fileDTO") FileDTO fileDTO);

	String getFileChangeName(@Param("fbId") int fbId);

	void deleteFile(@Param("fbId") int fbId, @Param("changeName") String changeName);
	

}

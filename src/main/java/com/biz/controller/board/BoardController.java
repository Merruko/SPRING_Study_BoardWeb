package com.biz.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.biz.service.board.BoardService;
import com.biz.vo.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "title");
		conditionMap.put("내용", "content");
		return conditionMap;
	}
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		if (vo.getTitle().equals("") || vo.getWriter().equals("") || vo.getContent().equals("")) {
			throw new NullPointerException("제목,작성자,내용은 반드시 입력해야 합니다.");
		}
		// 파일 업로드 처리
		MultipartFile multiPartFile = vo.getUploadFile();
		if (!multiPartFile.isEmpty()) {
			String fileName = multiPartFile.getOriginalFilename();
			multiPartFile.transferTo(new File("C:/upload/" + fileName));
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp"; // View 이름 리턴
	}

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		// Null Check
		if (vo.getSearchCondition() == null) vo.setSearchCondition("title");
		if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		return "getBoardList.jsp"; // View 이름 리턴
	}
}
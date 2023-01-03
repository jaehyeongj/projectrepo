package middleProjects.com.controller.board;

import lombok.RequiredArgsConstructor;
import middleProjects.com.dto.board.CreateBoardRequestDto;
import middleProjects.com.dto.board.CreateBoardResponseDto;
import middleProjects.com.dto.board.RetrieveBoardResponseDto;
import middleProjects.com.dto.board.UpdateBoardRequestDto;
import middleProjects.com.dto.board.UpdateBoardResponseDto;
import middleProjects.com.service.Board.BoardServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardServiceImpl boardServiceImpl;

    @PostMapping("/") //게시글 작성
    public CreateBoardResponseDto createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        return boardServiceImpl.createBoard(createBoardRequestDto);
    }

    @GetMapping("/") //전체 게시글 조회
    public List<RetrieveBoardResponseDto> retrieveBoardList() {
        return boardServiceImpl.retrieveBoardList();
    }

    @GetMapping("/{postId}") //아이디별 게시글 조회
    public RetrieveBoardResponseDto retrieveBoard(@PathVariable Long postId) {
        return boardServiceImpl.retrieveBoard(postId);
    }

    @PutMapping("/{postId}") //게시글 수정
    public UpdateBoardResponseDto updateBoard(@PathVariable Long postId, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {
        return boardServiceImpl.updateBoard(postId, updateBoardRequestDto);
    }

    @DeleteMapping("/{postId}") //게시글 삭제
    public void deleteBoard(@PathVariable Long postId) {
        boardServiceImpl.deleteBoard(postId);
    }
}

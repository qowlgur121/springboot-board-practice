package study.boardpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import study.boardpractice.service.BoardService;
import study.boardpractice.domain.Board;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board, Model model) {

        boardService.write(board);

        model.addAttribute("message", "정상적으로 게시글 등록되었습니다.");
        model.addAttribute("url", "/board/list");

        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    // localhost:8080/board/view?id=1
    @GetMapping("/board/view")
    public String boardView(Model model, Long id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Long id, Model model) {

        boardService.boardDelete(id);

        model.addAttribute("message", "정상적으로 삭제되었습니다");
        model.addAttribute("url", "/board/list");

        return "message";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Long id, Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }

    @Transactional
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Long id, Board board, Model model) {

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        model.addAttribute("message", "정상적으로 수정되었습니다.");
        model.addAttribute("url", "/board/list");

        return "message";
    }

}

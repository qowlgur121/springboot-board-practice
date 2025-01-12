package study.boardpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String boardWritePro(Board board) {

        boardService.write(board);

        return "";
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

}

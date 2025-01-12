package study.boardpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.boardpractice.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}

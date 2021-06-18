package com.example.demo.repository;
import com.example.demo.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BoardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create(Board board) throws Exception {
        //db 처리를 하기 때문에 exception 넣어줘야됨

        //insert into board: DB에 있는 BOARD 테이블에 값을 집어넣겠다.
        //(title, content, writer): board 테이블 내에 있는 컬럼들
        // values (?, ?, ?): 뭔가 값을 넣을 것인데 아직 미정이라는 의미
        String query = "insert into board (title, content, writer) values (?, ?, ?)";

        //jdbcTemplate.update(): 이것을 통해 실제 DB상의 값을 갱신
        //query: 구동시킬 DB의 쿼리
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
        // board객체안에 사용자의 입력으로 받은 title/content/content가 있고
        // 그걸 get해서 ? ? ? 에 넣겠다는 의미
    }
}
// repository는 실질적으로 data를 저장하거나 불러오거나 하는 작업을 처리하는 패키지로 지정
// entity는 실제 핵심 data를 관리 하는 부분
// controller는 controll
// service는 이 service가 어떤 service인지 알려주기 위해 배치
package com.example.demo.repository;


import com.example.demo.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;

// 컬럼을 조인시키는 경우가 아니면 작성할 것이 없다.
// db에 row를 넣을 수 있께 해주는 용도, 즉 자동으로 db(mysql)에 query를 구동(생성) 시킴
public interface VueJPAMemberRepository extends JpaRepository<VueMember, Long> {
}

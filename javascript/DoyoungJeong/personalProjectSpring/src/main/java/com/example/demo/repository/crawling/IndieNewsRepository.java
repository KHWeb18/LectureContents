package com.example.demo.repository.crawling;

import com.example.demo.entity.crawling.IndieNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndieNewsRepository extends JpaRepository<IndieNews, Long> {
}

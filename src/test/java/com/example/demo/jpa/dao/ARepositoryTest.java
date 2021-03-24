package com.example.demo.jpa.dao;

import com.example.demo.jpa.entiy.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(
        properties = {
                "spring.datasource.url = jdbc:simon:h2:mem:demodb;DB_CLOSE_DELAY=-1",
                "spring.datasource.driver-class-name = org.javasimon.jdbc4.Driver"
        }
)
//@ActiveProfiles("test")   application-test.yml
public class ARepositoryTest {
    @Autowired
    private ARepository aRepository;

    @Test
    @DisplayName("标准测试1")
    void test() {
        Optional<A> a = aRepository.findById((long) 1);
        System.out.println("A:: " + a.get());
    }
}

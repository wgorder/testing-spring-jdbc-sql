package com.example.demo.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("unittests")
@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    @SqlGroup({
            @Sql(scripts = {"classpath:person_schema.sql", "classpath:add_person1.sql", "classpath:add_person2.sql"}),
            @Sql(scripts = {"classpath:drop_person_table.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    })
    public void addPersonTest(){
        personService.addPerson();
    }
}
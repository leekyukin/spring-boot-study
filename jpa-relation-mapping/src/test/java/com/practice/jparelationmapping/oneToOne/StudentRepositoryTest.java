package com.practice.jparelationmapping.oneToOne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ComputerRepository computerRepository;

    @Test
    public void relationMappingTest() throws Exception {

        Student student = new Student();
        student.setName("이규진");

        Computer computer = new Computer();
        computer.setProductName("Mac Pro 14inch");


        student.setComputer(computer);

        computerRepository.save(computer);
        studentRepository.save(student);

        System.out.println("\n\n 컴퓨터!!!! >>>>>>>> " + studentRepository.findById(1L).orElseThrow().getComputer().getProductName());
    }

}
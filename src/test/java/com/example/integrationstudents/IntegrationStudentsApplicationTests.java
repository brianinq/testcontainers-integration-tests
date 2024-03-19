package com.example.integrationstudents;

import com.example.integrationstudents.entity.Student;
import com.example.integrationstudents.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationStudentsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Student student;

    @BeforeEach
    void setup(){
        studentRepository.deleteAll();
        student = Student
                .builder()
                .firstName("Alice")
                .lastName("Aliene")
                .email("aaliene@gmail.com")
                .build();
    }


    @Test
    @DisplayName("Test Create Student")
    public void givenStudent_whenCreateStudent_thenReturnStudent() throws Exception{
        //when
        ResultActions response = mockMvc.perform(
            post("/api/students")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(student))
        );
        //then
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$", CoreMatchers.notNullValue()));
    }


     @Test
     @DisplayName("Test get all students")
     public void givenStudentList_whenGetAllStudents_thenReturnStudentsList() throws Exception{
         //given - precondition / setup
         Student student1 = Student
                 .builder()
                 .firstName("test")
                 .lastName("stest")
                 .email("etesst@gamil.com")
                 .build();
         List<Student> studentList = List.of(student1,student);
         studentRepository.saveAll(studentList);

         //when - action or behaviour that we are testing
         ResultActions response =mockMvc.perform(
                 get("/api/students")
                         .accept("application/json")
         );
         //then - verify the output
         response.andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(2)));
     }



}

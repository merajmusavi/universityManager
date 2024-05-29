package com.example.universityManager;

import com.example.universityManager.dto.professor.AddProfessorDto;
import com.example.universityManager.enums.AcademicRank;
import com.example.universityManager.enums.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfessorControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenValidInput_thenReturn201() throws Exception {
        AddProfessorDto professorDto = new AddProfessorDto();
        professorDto.setBirthday(new Date());
        professorDto.setFamily("Doe");
        professorDto.setGender(Gender.MALE);
        professorDto.setName("John");
        professorDto.setNationalCode(123456789L);
        professorDto.setPassword("password");
        professorDto.setUsername("johniuidoe");
        professorDto.setAcademicRank(AcademicRank.PROFESSOR);
        professorDto.setCode(1001);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/professor/v1/save").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(professorDto));
        mockMvc.perform(request)
                .andExpect(status().isCreated());

    }
}

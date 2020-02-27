package com.cbnits.springboot_demo.controller;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static EmployeeRequest request;

    @BeforeAll
    public static void setUp() {
        request = new EmployeeRequest();
        request.setDesignation("developer");
        request.setName("Rahul");
        request.setSalary(23423532L);
    }

    @Order(1)
    @Test
    void createEmployee() throws Exception {

        String requestBody = objectMapper.writeValueAsString(request);
        System.out.println(requestBody);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/employees")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();

        MockHttpServletResponse mockMvcResponse = mvcResult.getResponse();

        int statusCode = mockMvcResponse.getStatus();
        String response = mockMvcResponse.getContentAsString();
        System.out.println("Response" + response);

        assertEquals(201, statusCode);

        Employee employee = objectMapper.readValue(response, Employee.class);

        assertEquals(request.getName(), employee.getName());
        assertEquals(request.getDesignation(), employee.getDesignation());
        assertEquals(request.getSalary(), employee.getSalary());

        assertTrue(employee.getId() > 0);
    }

    @Order(2)
    @Test
    void getAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/employees");
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(200, response.getStatus());

        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

        List<Employee> employees = objectMapper.readValue(contentAsString, new TypeReference<List<Employee>>() {});
        assertEquals(1, employees.size());

        Employee employee = employees.get(0);
        assertEquals(request.getName(), employee.getName());
        assertEquals(request.getDesignation(), employee.getDesignation());
        assertEquals(request.getSalary(), employee.getSalary());

        assertTrue(employee.getId() > 0);
    }

    @Order(3)
    @Test
    void get1() {
        System.out.println("get1");
    }

    @Order(5)
    @Test
    void delete() {
        System.out.println("delete");
    }

    @Order(4)
    @Test
    void update() {
        System.out.println("update");
    }
}
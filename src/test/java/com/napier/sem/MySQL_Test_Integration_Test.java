package com.napier.sem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySQL_Test_Integration_Test {
    MySQL_Test mytest;

    @BeforeEach
    void setUp() {
        mytest = new MySQL_Test();
        mytest.connect("localhost:33060", 10000);
    }

    @Test
    void testGetEmployee() {
        Employee emp = mytest.getEmployee(255530);
        assertEquals(255530, emp.emp_no);
        assertEquals("Ronghao", emp.first_name);
        assertEquals("Garigliano", emp.last_name);
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee();
        emp.emp_no = 500001;
        emp.first_name = "Myo Pa Pa";
        emp.last_name = "Kyaw";
        mytest.addEmployee(emp);
        emp = mytest.getEmployee(500001);
        assertEquals(emp.emp_no, 500001);
        assertEquals(emp.first_name, "Myo Pa Pa");
        assertEquals(emp.last_name, "Kyaw");
    }
}
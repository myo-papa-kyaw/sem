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

        // Ensure test employee for testGetEmployee exists
        Employee emp = new Employee();
        emp.emp_no = 255530;
        emp.first_name = "Ronghao";
        emp.last_name = "Garigliano";
        mytest.addEmployee(emp);
    }

    @Test
    void testGetEmployee() {
        Employee emp = mytest.getEmployee(255530);

        // Null check
        assertNotNull(emp, "Employee should not be null for emp_no = 255530");

        assertEquals(255530, emp.emp_no);
        assertEquals("Ronghao", emp.first_name);
        assertEquals("Garigliano", emp.last_name);
    }

    @Test
    void testAddEmployee() {
        // Create a new employee to add
        Employee emp = new Employee();
        emp.emp_no = 500001;
        emp.first_name = "Myo Pa Pa";
        emp.last_name = "Kyaw";

        // Add employee
        mytest.addEmployee(emp);

        // Retrieve the employee from DB
        Employee addedEmp = mytest.getEmployee(500001);

        // Null check
        assertNotNull(addedEmp, "Employee should not be null after adding to DB");

        // Validate data
        assertEquals(500001, addedEmp.emp_no);
        assertEquals("Myo Pa Pa", addedEmp.first_name);
        assertEquals("Kyaw", addedEmp.last_name);
    }
}

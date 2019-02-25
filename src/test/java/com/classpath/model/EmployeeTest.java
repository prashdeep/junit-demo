package com.classpath.model;

import static org.junit.Assert.*;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    Employee employee;
    @Mocked Address address;

    @Before
    public void setUp(){
       employee =  new Employee(34, "Vinay");
    }
    @Test
    public void testEmployeeConstructor(){

        assertEquals(34, employee.getEmpId());
        assertEquals("Vinay", employee.getName());
    }

    @Test
    public void testSetEmpId(){
        assertEquals("Vinay", employee.getName());
        employee.setName("Hari");
        assertEquals("Hari", employee.getName());
    }

    @Test
    public void testInvalidFirstName(){
        String firstName = null;
        String lastName = "KUmar";
        try {
            employee.constructFullName(firstName, lastName);
            fail("This test case should throw exception");
        } catch (Exception exception){
          assertTrue(exception instanceof IllegalArgumentException);
          assertEquals("First name and last name should be present", exception.getMessage());
        }
    }

    @Test
    public void testInvalidLastName(){
        String firstName = "Vinay";
        String lastName = null;
        try {
            employee.constructFullName(firstName, lastName);
            fail("This test case should throw exception");
        } catch (Exception exception){
            assertTrue(exception instanceof IllegalArgumentException);
            assertEquals("First name and last name should be present", exception.getMessage());
        }
    }

    @Test
    public void testInvalidFistNameAndLastName(){
        String firstName = null;
        String lastName = null;
        try {
            employee.constructFullName(firstName, lastName);
            fail("This test case should throw exception");
        } catch (Exception exception){
            assertTrue(exception instanceof IllegalArgumentException);
            assertEquals("First name and last name should be present", exception.getMessage());
        }
    }

    @Test
    public void testValidFistNameAndLastName(){
        String firstName = "Naveen";
        String lastName = "Kumar";
        try {
            String result = employee.constructFullName(firstName, lastName);
            assertEquals("Naveen Kumar", result);
        } catch (Exception exception){
            fail("Must not throw exception");
        }
    }

    @Test
    public void testInvalidPrintAddress(){
        employee.printEmployeeDetails(address);
        new Verifications(){{
           address.printAddress(); times = 1;

        }};
    }

    @Test
    public void testValidWithBangaloreCity(){
        new Expectations(){{
           address.getCity(); result = "Bangalore";
        }};
        employee.printEmployeeDetails(address);
        new Verifications(){{
            address.printAddress(); times = 1;
        }};
    }

    @Test
    public void testValidWithBangaloreStreet(){
        new Expectations(){{
            address.getCity(); result = "Mangalore";
            address.getStreet(); result = "1st Block";
        }};
        employee.printEmployeeDetails(address);
        new Verifications(){{
            address.printAddress(); times = 0;
        }};
    }

}
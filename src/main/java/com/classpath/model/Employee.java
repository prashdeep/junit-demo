package com.classpath.model;

public class Employee {

    private  long empId;
    private String name;

    public Employee(long empId, String name){
        this.empId = empId;
        this.name= name;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String constructFullName(String firstName, String lastName){
        if (firstName == null || lastName == null){
            throw new IllegalArgumentException("First name and last name should be present");
        }
        return firstName + " " +lastName;
    }

    public void printEmployeeDetails(Address address){

        if(address != null) {
            if (address.getCity().equalsIgnoreCase("Bangalore")) {
                address.printAddress();
            } else if (address.getStreet().equalsIgnoreCase("Ist Block")){
                System.out.println("address is in Jayanagar");
            } else if (address.getZipCode().equalsIgnoreCase("577142")){
                address.printAddress();
            }
        }
    }
}
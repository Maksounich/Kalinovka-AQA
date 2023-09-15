package org.example.pojo;

import org.testng.Assert;

public class AssertionsApi {

    public static void assertStudent(StudentPojo expectedStudent, StudentResponse actualStudent) {
        Assert.assertEquals(expectedStudent.getName(), actualStudent.getName());
        Assert.assertEquals(expectedStudent.getEmail(), actualStudent.getEmail());
        Assert.assertEquals(expectedStudent.getOffice(), actualStudent.getOffice());
        Assert.assertEquals(expectedStudent.getMentor(), actualStudent.getMentor());
    }
}

package com.maturanec.pmalv1;

import java.util.ArrayList;
import java.util.List;

public class StudentSingleton {

    private static StudentSingleton oInstance = null;
    private ArrayList<Student> lStudenti = new ArrayList<>();
    protected StudentSingleton() {
    }
    public static StudentSingleton getInstance() {
        if(oInstance == null) {
            oInstance = new StudentSingleton();
        }
        return oInstance;
    }
    public List<Student> getStudenti()
    {
        return lStudenti;
    }
    public  void addStudent(Student student)
    {
        lStudenti.add(student);
    }
}

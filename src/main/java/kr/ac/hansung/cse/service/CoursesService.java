package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CoursesDao;
import kr.ac.hansung.cse.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    private CoursesDao coursesDao;

    public List<Courses> getYearCourses(int year, int semester){return coursesDao.getYearCourses(year,semester);}

    public int getCreditSum(int year, int semester){
        int creditSum = coursesDao.getCreditSum(year, semester);
        return creditSum;
    }

    public void insert(Courses courses) {
        coursesDao.insert(courses);
    }
}

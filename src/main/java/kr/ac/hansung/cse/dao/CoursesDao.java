package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoursesDao {
    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Courses> getCourses() { //수강한 교과목 나열

        String sqlStatement= "select * from courses"; //courses테이블에서 db 가져오기
        return jdbcTemplate.query(sqlStatement, new RowMapper<Courses>() {

            @Override
            public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {

                Courses courses = new Courses();
                courses.setYear(rs.getInt("year"));
                courses.setSemester(rs.getInt("semester"));
                courses.setCourseId(rs.getString("courseId"));
                courses.setCourseName(rs.getString("courseName"));
                courses.setClassification(rs.getString("classification"));
                courses.setProfessor(rs.getString("professor"));
                courses.setCredit(rs.getInt("credit"));

                return courses;
            }
        });
    }
    
    public List<Courses> getYearCourses(int year, int semester) { //학년별 이수 학점 조회

        String sqlStatement= "select * from courses where year = ? and semester = ?"; //courses테이블에서 year과 semester에 맞게 db 가져오기
        return jdbcTemplate.query(sqlStatement, new Object[] {year, semester},
                new RowMapper<Courses>() {

                    @Override
                    public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Courses courses = new Courses();
                        courses.setYear(rs.getInt("year"));
                        courses.setSemester(rs.getInt("semester"));
                        courses.setCourseId(rs.getString("courseId"));
                        courses.setCourseName(rs.getString("courseName"));
                        courses.setClassification(rs.getString("classification"));
                        courses.setProfessor(rs.getString("professor"));
                        courses.setCredit(rs.getInt("credit"));

                        return courses;
                    }
                });
    }

    public int getCreditSum(int year, int semester){
        String sql = "select sum(credit) from courses where year = ? and semester = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{year, semester}, Integer.class);
    }
    
    public boolean insert(Courses courses) {//2024학년도 2학기 수강신청
        int year = courses.getYear();
        int semester = courses.getSemester();
        String courseId = courses.getCourseId();
        String courseName = courses.getCourseName();
        String classification = courses.getClassification();
        String professor = courses.getProfessor();
        int credit = courses.getCredit();

        String sqlStatement= "insert into courses (year, semester, courseId, courseName, classification, professor, credit) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, courseId, courseName, classification, professor, credit}) == 1);
    }


}

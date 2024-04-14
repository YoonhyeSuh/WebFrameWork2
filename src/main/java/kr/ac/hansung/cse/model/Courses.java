package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor //인자 없는 생성자

public class Courses {

    @NotNull(message = "Year must not be null")
    private Integer year;
    @NotNull(message = "Semester must not be null")
    private Integer semester;
    @Size(min=2, max=100, message = "CourseId must be between 2 and 100 chars")
    private String courseId;
    @Size(min=2, max=100, message = "CourseName must be between 2 and 100 chars")
    private String courseName;
    @Size(min=2, max=100, message = "Classification must be between 전필, 전선, 전기, 교필, 선필교, 일교")
    private String classification;
    @Size(min=2, max=100, message = "Professor must be between 2 and 100 chars")
    private String professor;
    @NotNull(message = "Credit must not be null")
    private Integer credit;
}

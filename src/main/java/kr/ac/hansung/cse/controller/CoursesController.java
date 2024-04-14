package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Courses;
import kr.ac.hansung.cse.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping("/showcourseslist")
    public String showCoursesList(Model model){

        int creditSum20211 = coursesService.getCreditSum(2021,1);
        int creditSum20212 = coursesService.getCreditSum(2021,2);
        int creditSum20221 = coursesService.getCreditSum(2022,1);
        int creditSum20222 = coursesService.getCreditSum(2022,2);
        int creditSum20231 = coursesService.getCreditSum(2023,1);
        int creditSum20232 = coursesService.getCreditSum(2023,2);
        int creditSum20241 = coursesService.getCreditSum(2024,1);
        int creditTotalSum = creditSum20211+ creditSum20212 + creditSum20221 + creditSum20222 + creditSum20231 + creditSum20232 + creditSum20241;

        model.addAttribute("creditSum20211", creditSum20211);
        model.addAttribute("creditSum20212", creditSum20212);
        model.addAttribute("creditSum20221", creditSum20221);
        model.addAttribute("creditSum20222", creditSum20222);
        model.addAttribute("creditSum20231", creditSum20231);
        model.addAttribute("creditSum20232", creditSum20232);
        model.addAttribute("creditSum20241", creditSum20241);
        model.addAttribute("creditTotalSum", creditTotalSum);

        return "showcourseslist";
    }

    @GetMapping("/detail20211")
    public String deatil20211(Model model){
        List<Courses> courses20211 = coursesService.getYearCourses(2021,1);
        model.addAttribute("courses20211",courses20211);
        return "detail20211";
    }

    @GetMapping("/detail20212")
    public String deatil20212(Model model){
        List<Courses> courses20212 = coursesService.getYearCourses(2021,2);
        model.addAttribute("courses20212",courses20212);
        return "detail20212";
    }

    @GetMapping("/detail20221")
    public String deatil20221(Model model){
        List<Courses> courses20221 = coursesService.getYearCourses(2022,1);
        model.addAttribute("courses20221",courses20221);
        return "detail20221";
    }

    @GetMapping("/detail20222")
    public String deatil20222(Model model){
        List<Courses> courses20222 = coursesService.getYearCourses(2022,2);
        model.addAttribute("courses20222",courses20222);
        return "detail20222";
    }

    @GetMapping("/detail20231")
    public String deatil20231(Model model){
        List<Courses> courses20231 = coursesService.getYearCourses(2023,1);
        model.addAttribute("courses20231",courses20231);
        return "detail20231";
    }

    @GetMapping("/detail20232")
    public String detail20232(Model model){
        List<Courses> courses20232 = coursesService.getYearCourses(2023,2);
        model.addAttribute("courses20232",courses20232);
        return "detail20232";
    }

    @GetMapping("/detail20241")
    public String detail20241(Model model){
        List<Courses> courses20241 = coursesService.getYearCourses(2024,1);
        model.addAttribute("courses20241",courses20241);
        return "detail20241";
    }


    @GetMapping("/createcourses")
    public String createCourse(Model model) {

        model.addAttribute("courses", new Courses());

        return "createcourses";
    }

    @GetMapping("/showcourses")
    public String showCourses(Model model){
        List<Courses> courses20242 = coursesService.getYearCourses(2024,2);
        model.addAttribute("courses20242", courses20242);

        return "showcourses";
    }

    @PostMapping("/coursescreated")
    public String doCreate(Model model, @Valid Courses courses, BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createcourses";
        }

        // Controller -> Service -> Dao
        coursesService.insert(courses);

        return "coursescreated";
    }
}

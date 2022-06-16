package com.course.mapper;


import com.course.MapperApplication;
import com.course.pojo.StudentInfo;
import com.course.qo.CourseInfoQo;
import com.course.qo.StudentInfoQo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapperApplication.class)
public class CourseInfoTest {


    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    private StudentInfoMapper studentInfoMapper;


    @Test
    public void test(){
        CourseInfoQo courseInfoQo=new CourseInfoQo();
        StudentInfoQo studentInfoQo=new StudentInfoQo();
        studentInfoQo.setStudentName("student01");
        studentInfoQo.setStudentPwd("123456");
        StudentInfo studentInfo = studentInfoMapper.judgeLogin(studentInfoQo);
        System.out.println(studentInfo);
        courseInfoQo.setNowPage(0);
        courseInfoQo.setDivideNum(8);
        System.out.println(courseInfoMapper.showAllCourseByConditionCount(courseInfoQo));
    }
}

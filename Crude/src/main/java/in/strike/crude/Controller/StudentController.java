package in.strike.crude.Controller;

import in.strike.crude.Service.StudentService;
import in.strike.crude.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  private StudentService studentService;
  public StudentController(StudentService studentService){
      this.studentService= studentService;
  }
    @PostMapping
    public ResponseEntity<Student>  createStudent(@RequestBody Student student){
        System.out.println("Inside Student Controller");
     Student createdStudent = studentService.createStudent(student);
        System.out.println("Exiting Student Controller");
//       return ResponseEntity.ok(createdStudent);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        return ResponseEntity.status(201).body(createdStudent);
    }
    // get student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){

                Student studentResp=studentService.getService(id);
                if (studentResp==null){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                   return ResponseEntity.ok(studentResp);

    }
  //get all student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
            List<Student>  studentsList    =  studentService.getAllService();
            if(studentsList.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(studentsList);
    }

    //update student details
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentreq){

      Student studentResp =studentService.updateStudentService(id,studentreq);
      if(studentResp==null){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(studentreq);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteStudent(@PathVariable Long id){
       Boolean isDeleted = studentService.deleteStudent(id);
       if(!isDeleted){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok("Record deleted");
    }

}

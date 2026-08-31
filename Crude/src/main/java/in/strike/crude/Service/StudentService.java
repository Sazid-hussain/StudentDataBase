package in.strike.crude.Service;

import in.strike.crude.StudentRepository.StudentRepository;
import in.strike.crude.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
         private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq){
        System.out.println("Inside Student Service");
        Student studentResp = studentRepository.save(studentReq);
        System.out.println("Exiting Student Service");
        return studentReq;
    }

    public Student getService(Long id){
          Optional<Student> studentResp =studentRepository.findById(id);
          if(studentResp.isPresent()){
              return studentResp.get();
          }
          return null;
    }

    public List<Student> getAllService(){
          List<Student> studentResp = studentRepository.findAll();

          return studentResp;
    }
    public Student updateStudentService(Long id,Student studentReq){
        Optional<Student> existingStudent = studentRepository.findById(id);
          if(existingStudent.isEmpty()){
              return null;
          }

          Student savaToStudent = existingStudent.get();
            savaToStudent.setRollNo(studentReq.getRollNo());
            savaToStudent.setEmail(studentReq.getEmail());
            savaToStudent.setSubject(studentReq.getSubject());
            savaToStudent.setName(studentReq.getName());
            savaToStudent.setAge(studentReq.getAge());
            return studentRepository.save(savaToStudent);
    }

    public Boolean deleteStudent(Long id){
             Boolean isStudent= studentRepository.existsById(id);
            if(!isStudent){
                return false;
            }

            studentRepository.deleteById(id);
            return true;
    }
}

package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.Entity.ClassAPI;
import com.systemSchool.School.api.Entity.StudentAPI;
import com.systemSchool.School.api.Repository.ClassRepository;
import com.systemSchool.School.api.Repository.StudentRepository;
import com.systemSchool.School.api.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public  class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    public StudentServiceImpl(StudentRepository studentRepository,ClassRepository classRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }
    @Override
    public Optional<StudentDTO> addClass(Long studentId, Long classId) {
        // 1️⃣ Get student from DB
        StudentAPI student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // 2️⃣ Get class from DB
        ClassAPI classAPI = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        // 3️⃣ Set relation
        student.setClassAPI(classAPI);

        // 4️⃣ Save (UPDATE)
        studentRepository.save(student);
        return Optional.empty();
    }

    @Override
    public void newStudent(StudentDTO student) {
        StudentAPI stu = new StudentAPI();
        stu.setStudentName(student.getStudentName());
        stu.setGender(student.getGender());
        stu.setDob(student.getDob());
        stu.setEmail(student.getEmail());
        studentRepository.save(stu);
    }

    @Override
    public void updateStudent(StudentDTO student, Long id) {
        Optional<StudentAPI> stu = studentRepository.findById(id);
        if (stu.isEmpty()) {
            log.error("Student not found",id);
        }
        StudentAPI stud = stu.get();
        stud.setStudentName(stu.get().getStudentName());
        stud.setGender(stu.get().getGender());
        stud.setDob(stu.get().getDob());
        stud.setEmail(stu.get().getEmail());
        studentRepository.save(stud);

    }

    @Override
    public StudentDTO deleteStudent(Long id) {
        Optional<StudentAPI> stu = studentRepository.findById(id);
        if (stu.isEmpty()) {
            log.error("Student not found",id);
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName(stu.get().getStudentName());
        studentDTO.setGender(stu.get().getGender());
        studentDTO.setDob(stu.get().getDob());
        studentDTO.setEmail(stu.get().getEmail());
        studentRepository.deleteById(id);
        return studentDTO;
    }

    @Override
    public StudentDTO getStudent(Long id) {
        StudentDTO student = new StudentDTO();
        Optional<StudentAPI> stu = studentRepository.findById(id);
        if (stu.isEmpty()) {
            log.error("Student not found",id);
            return null;
        }
        student.setStudentId(stu.get().getStudentId());
        student.setStudentName(stu.get().getStudentName());
        student.setGender(stu.get().getGender());
        student.setDob(stu.get().getDob());
        student.setEmail(stu.get().getEmail());
        ClassAPI clazz = new ClassAPI();
        if(clazz != null){
            ClassDTO classDTO = new ClassDTO();
            classDTO.setClassId(clazz.getClassId());
            classDTO.setClassName(clazz.getClassName());
            classDTO.setClassNumber(classDTO.getClassNumber());
            student.setClassDTO(classDTO);
        }
        return student;
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<StudentAPI> students = studentRepository.findAll();

        return students.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private StudentDTO mapToDTO(StudentAPI student) {
        StudentDTO studentDTO = new StudentDTO();
                studentDTO.setStudentId(student.getStudentId());
                studentDTO.setStudentName(student.getStudentName());
                studentDTO.setDob(student.getDob());
                studentDTO.setEmail(student.getEmail());
                studentDTO.setClassDTO(new ClassDTO());
        return studentDTO;
    }
}

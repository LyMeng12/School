package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Model.StudentAPI;
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
    public Optional<StudentDTO> addClass(Long id, Long classDTO) {
        Optional<StudentAPI> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            log.error("Student with id {} not found", id);
            return Optional.empty();
        }

        Optional<ClassAPI> optionalClass = classRepository.findById(classDTO);

        if (optionalClass.isEmpty()) {
            log.error("Class with id {} not found", classDTO);
            return Optional.empty();
        }

        StudentAPI student = optionalStudent.get();
        ClassAPI classAPI = optionalClass.get();

        student.setClassAPI(classAPI);

        StudentAPI savedStudent = studentRepository.save(student);

        return Optional.of(mapToDTO(savedStudent));

    }

    @Override
    public StudentDTO deleteClass(Long studentId) {
        Optional<StudentAPI> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isEmpty()) {
            log.error("Student with id {} not found", studentId);
            return null;
        }
        StudentAPI student = optionalStudent.get();
        student.setClassAPI(null);
        studentRepository.save(student);
        return student;
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
        stud.setStudentName(student.getStudentName());
        stud.setGender(student.getGender());
        stud.setDob(student.getDob());
        stud.setEmail(student.getEmail());
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
        Optional<StudentAPI> stu = studentRepository.findById(id);
        if (stu.isEmpty()) {
            log.error("Student not found",id);
            return null;
        }
        StudentAPI student = stu.get();
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setStudentName(student.getStudentName());
        studentDTO.setGender(student.getGender());
        studentDTO.setDob(student.getDob());
        studentDTO.setEmail(student.getEmail());

        if (student.getClassAPI() != null) {

            ClassAPI classAPI = student.getClassAPI();

            ClassDTO classDTO = new ClassDTO();
            classDTO.setClassId(classAPI.getClassId());
            classDTO.setClassName(classAPI.getClassName());
            classDTO.setClassNumber(classAPI.getClassNumber());
            studentDTO.setClassDTO(classDTO);
        }
        return studentDTO;
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

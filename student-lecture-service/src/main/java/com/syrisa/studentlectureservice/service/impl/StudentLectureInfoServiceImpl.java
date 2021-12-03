package com.syrisa.studentlectureservice.service.impl;

import com.syrisa.studentlectureservice.client.GenerateProcessClient;
import com.syrisa.studentlectureservice.entity.impl.StudentLecture;
import com.syrisa.studentlectureservice.entity.impl.StudentLectureInfo;
import com.syrisa.studentlectureservice.repository.StudentLectureRepository;
import com.syrisa.studentlectureservice.service.StudentLectureInfoService;
import com.syrisa.studentlectureservice.service.StudentLectureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentLectureInfoServiceImpl implements StudentLectureInfoService {



    private final StudentLectureService studentLectureService;
    private final GenerateProcessClient generateProcessClient;
    private final StudentLectureRepository studentLectureRepository;


    public StudentLectureInfoServiceImpl(StudentLectureService studentLectureService, GenerateProcessClient generateProcessClient, StudentLectureRepository studentLectureRepository) {
        this.studentLectureService = studentLectureService;
        this.generateProcessClient = generateProcessClient;
        this.studentLectureRepository = studentLectureRepository;
    }

    @Override
    public StudentLecture create(StudentLectureInfo studentLectureInfo) {
      /*  try {
            StudentLecture studentLecture = studentLectureService.findStudentLectureByStudentNumber(studentLectureInfo.getStudentNumber());
            List<InstructorLec> instructorLectures = null;
            InstructorLec instructorLec = null;
            if (studentLecture == null) {
                instructorLectures = new ArrayList<>();
                Student student = studentService.getByID(studentLectureInfo.getStudentNumber());
                instructorLec = instructorLecProcessClient.getById(studentLectureInfo.getStudentLectureCode()).toInstructorLec();
                setStudentLectureInfo(studentLecture, instructorLectures, instructorLec, student);
            } else {
                instructorLec = instructorLecProcessClient.getById(studentLectureInfo.getStudentLectureCode()).toInstructorLec();
                instructorLectures = studentLecture.getStudentLectures();
                if (isStudentLectureCountLessThan.test(instructorLectures)) {
                    instructorLectures.add(instructorLec);
                    studentLecture.setStudentLectures(instructorLectures);
                } else {
                    throw new StudentExceedLectureBoundsException("The student can choose a maximum of 2 courses.");
                }
            }
            instructorLec.setStudentCapacity(instructorLec.getStudentCapacity() + 1);
            instructorLecProcessClient.update(instructorLec.toInstructorLecDto());
            return studentLectureRepository.save(studentLecture);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }*/
        return null;
    }

    /*private void setStudentLectureInfo(StudentLecture studentLecture, List<InstructorLec> instructorLectures, InstructorLec instructorLec, Student student) {
        studentLecture.setStudentLecID(Long.valueOf(generateProcessClient.generateNumber(6)));
        studentLecture.setLastUpdated(LocalDate.now());
        studentLecture.setStudentNumber(student.getStudentNumber());
        studentLecture.setStudentNameAndSurname(student.getStudentName() + " " + student.getStudentLastName());
        instructorLectures.add(instructorLec);
        studentLecture.setStudentLectures(instructorLectures);
    }

    private final Predicate<List<InstructorLec>> isStudentLectureCountLessThan = (instructorLectures -> instructorLectures.size() < 2);
*/

}

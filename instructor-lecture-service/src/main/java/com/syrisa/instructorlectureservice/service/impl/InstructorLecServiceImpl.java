package com.syrisa.instructorlectureservice.service.impl;

import com.syrisa.instructorlectureservice.entity.impl.InstructorLec;
import com.syrisa.instructorlectureservice.repository.InstructorLecRepository;
import com.syrisa.instructorlectureservice.service.InstructorLecService;
import com.syrisa.instructorlectureservice.utilities.checkobject.PreCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.BiFunction;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class InstructorLecServiceImpl implements InstructorLecService {

    private final InstructorLecRepository instructorLecRepository;

    @Override
    public InstructorLec getByID(Long id) {
        return instructorLecRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "InstructorLec is not found"));
    }

    @Override
    public InstructorLec getByLectureCode(String lectureCode) {
        return instructorLecRepository.findByLectureCode(lectureCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lecture not found"));
    }

    @Override
    public String delete(Long id) {
        try {
            InstructorLec instructorLec = getByID(id);
            instructorLecRepository.delete(instructorLec);
            return instructorLec.getLectureCode() + "code Lecture was deleted.";
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public InstructorLec addStudent(Long instructorLecID) {
        try {
            InstructorLec editedInstructor = getByID(instructorLecID);
            if (checkStudentCapacity.apply(editedInstructor.getStudentCapacity(),editedInstructor.getStudentCount())){
                editedInstructor.setStudentCapacity(editedInstructor.getStudentCapacity() + 1);
                return instructorLecRepository.save(editedInstructor);
            }
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,editedInstructor.getInstructorNameSurname()+" named instructor lecture is fulled");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public InstructorLec create(InstructorLec instructorLec) {
        try {
            PreCondition.checkNull(instructorLec);
            if (instructorLec.getStudentCapacity()==0)
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please this field should not 0");
            return instructorLecRepository.save(instructorLec);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public InstructorLec update(InstructorLec instructorLec) {
        try {
            return null;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }


    @Override
    public Page<InstructorLec> getAll(Pageable pageable) {
        return instructorLecRepository.findAll(pageable);
    }

    private final BiFunction<Integer, Integer, Boolean> checkStudentCapacity = (lectureCapacity, studentCapacity) -> studentCapacity <= lectureCapacity;
}

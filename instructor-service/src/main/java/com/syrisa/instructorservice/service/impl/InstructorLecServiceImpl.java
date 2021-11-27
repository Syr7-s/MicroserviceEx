package com.syrisa.instructorservice.service.impl;

import com.syrisa.instructorservice.client.LectureProcessClient;
import com.syrisa.instructorservice.entity.impl.Instructor;
import com.syrisa.instructorservice.entity.impl.InstructorLec;
import com.syrisa.instructorservice.entity.impl.Lecture;
import com.syrisa.instructorservice.exception.StudentCapacityExceededException;
import com.syrisa.instructorservice.repository.InstructorLecRepository;
import com.syrisa.instructorservice.service.InstructorLecService;
import com.syrisa.instructorservice.service.InstructorService;
import com.syrisa.instructorservice.utility.checkobject.ObjectContainerService;
import io.vavr.collection.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service
@Transactional(rollbackFor = Exception.class)
public class InstructorLecServiceImpl implements InstructorLecService {
    private final LectureProcessClient lectureProcessClient;
    private final InstructorLecRepository instructorLecRepository;
    private final InstructorService instructorService;

    public InstructorLecServiceImpl(LectureProcessClient lectureProcessClient, InstructorLecRepository instructorLecRepository, InstructorService instructorService) {
        this.lectureProcessClient = lectureProcessClient;
        this.instructorLecRepository = instructorLecRepository;
        this.instructorService = instructorService;
    }

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
    public InstructorLec create(InstructorLec instructorLec) {
        try {
            if (new ObjectContainerService<Lecture>().isNull.test(lectureProcessClient.getLectureCode(instructorLec.getLectureCode()))) {
                Instructor instructor = instructorService.getByID(instructorLec.getInstructorLecID());
                instructorLec.setInstructorNameSurname(instructor.getInstructorName() + " " + instructor.getInstructorLastName());
                return instructorLecRepository.save(instructorLec);
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public InstructorLec update(InstructorLec instructorLec) {
        try {
            InstructorLec editedInstructor = getByID(instructorLec.getInstructorLecID());
            if (!Objects.equals(editedInstructor.getLectureCode(), instructorLec.getLectureCode())) {
                throw new Exception("Instructor Lecture Code must not edited.");
            } else {
                Integer lectureCapacity = lectureProcessClient.getLectureCode(editedInstructor.getLectureCode()).getLectureCapacity();
                boolean result = checkStudentCapacity.apply(lectureCapacity, editedInstructor.getStudentCapacity());
                if (result) {
                    return instructorLecRepository.save(instructorLec);
                }
                throw new StudentCapacityExceededException("StudentCapacity was exceeded.");
            }
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

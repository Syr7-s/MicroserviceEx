package com.syrisa.instructorservice.service.impl;

import com.syrisa.instructorservice.client.LectureProcessClient;
import com.syrisa.instructorservice.entity.impl.Instructor;
import com.syrisa.instructorservice.entity.impl.InstructorLec;
import com.syrisa.instructorservice.entity.impl.Lecture;
import com.syrisa.instructorservice.repository.InstructorLecRepository;
import com.syrisa.instructorservice.service.InstructorLecService;
import com.syrisa.instructorservice.service.InstructorService;
import com.syrisa.instructorservice.utility.checkobject.ObjectContainerService;
import io.vavr.collection.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
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
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public InstructorLec create(InstructorLec instructorLec) {
        try{
            if (new ObjectContainerService<Lecture>().isNull.test(lectureProcessClient.getLectureCode(instructorLec.getLectureCode()))) {
                Instructor instructor = instructorService.getByID(instructorLec.getInstructorLecID());
                instructorLec.setInstructorNameSurname(instructor.getInstructorName() + " " + instructor.getInstructorLastName());
                return instructorLecRepository.save(instructorLec);
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @Override
    public InstructorLec update(InstructorLec instructorLec) {
        return null;
    }

    @Override
    public List<InstructorLec> getAll() {
        return null;
    }
}

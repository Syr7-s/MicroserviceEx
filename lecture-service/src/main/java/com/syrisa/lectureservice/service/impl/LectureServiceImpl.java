package com.syrisa.lectureservice.service.impl;

import com.syrisa.lectureservice.client.GenerateProcessClient;
import com.syrisa.lectureservice.entity.Lecture;
import com.syrisa.lectureservice.exceptions.LectureNotNullException;
import com.syrisa.lectureservice.repository.LectureRepository;
import com.syrisa.lectureservice.service.LectureService;
import io.vavr.collection.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class LectureServiceImpl implements LectureService<Lecture> {

    private final LectureRepository lectureRepository;
    private final GenerateProcessClient generateProcessClient;

    public LectureServiceImpl(LectureRepository lectureRepository, GenerateProcessClient generateProcessClient) {
        this.lectureRepository = lectureRepository;
        this.generateProcessClient = generateProcessClient;
    }

    @Override
    public Lecture create(Lecture lecture) {
        try {
            if (lecture != null) {
                lecture.setLectureID(Integer.parseInt(generateProcessClient.generateNumber(4)));
                return lectureRepository.save(lecture);
            }
            throw new LectureNotNullException("Lecture not created.");

        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public Lecture update(Lecture lecture) {
        return null;
    }

    @Override
    public Lecture getByID(Long id) {
        return null;
    }

    @Override
    public List<Lecture> getAll() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Lecture getLectureByLectureCode(String lectureCode) {
        try{
            Lecture lecture = lectureRepository.findLectureByLectureCode(lectureCode);
            if (lecture != null) {
                return lecture;
            }
            throw new LectureNotNullException("Lecture is not found");
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }
}

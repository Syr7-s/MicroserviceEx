package com.syrisa.lectureservice.service.impl;

import com.syrisa.lectureservice.entity.Lecture;
import com.syrisa.lectureservice.exceptions.LectureNotNullException;
import com.syrisa.lectureservice.repository.LectureRepository;
import com.syrisa.lectureservice.service.LectureService;
import com.syrisa.lectureservice.utilities.generate.impl.NumberGenerate;
import io.vavr.collection.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class LectureServiceImpl implements LectureService<Lecture> {

    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture create(Lecture lecture) {
        try {
            if (lecture != null) {
                lecture.setLectureID(NumberGenerate.generate.generate(4));
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
}

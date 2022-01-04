package com.syrisa.lectureservice.service.impl;

import com.syrisa.lectureservice.client.GenerateProcessClient;
import com.syrisa.lectureservice.entity.Lecture;
import com.syrisa.lectureservice.exceptions.LectureNotNullException;
import com.syrisa.lectureservice.repository.LectureRepository;
import com.syrisa.lectureservice.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService<Lecture> {
    private final LectureRepository lectureRepository;
    private final GenerateProcessClient generateProcessClient;

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
        try {
            Lecture editedLecture = getByID(lecture.getLectureID());
            if (editedLecture != null) {
                return lectureRepository.save(lecture);
            }
            throw new Exception("Not found");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @Override
    public Lecture getByID(Integer id) {
        return lectureRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " lecture not found."));
    }

    @Override
    public Page<Lecture> getAll(Pageable pageable) {
        return lectureRepository.findAll(pageable);
    }

    @Override
    public String delete(Integer id) {
        try{
            Lecture lecture = getByID(id);
            if (lecture!=null){
                lectureRepository.delete(lecture);
                return lecture.getLectureCode()+" code lecture was removed";
            }
            return lecture.getLectureName()+" named lecture was not removed";
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @Override
    public Lecture getLectureByLectureCode(String lectureCode) {
        try {
            Lecture lecture = lectureRepository.findLectureByLectureCode(lectureCode);
            if (lecture != null) {
                return lecture;
            }
            throw new LectureNotNullException("Lecture is not found");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }


    }
}

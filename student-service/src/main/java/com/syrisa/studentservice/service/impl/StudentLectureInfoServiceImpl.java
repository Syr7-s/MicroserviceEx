package com.syrisa.studentservice.service.impl;

import com.syrisa.studentservice.entity.StudentLectureInfo;
import com.syrisa.studentservice.service.StudentLectureInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentLectureInfoServiceImpl implements StudentLectureInfoService {
    @Override
    public StudentLectureInfo create(StudentLectureInfo studentLectureInfo) {
        return null;
    }

    @Override
    public StudentLectureInfo update(StudentLectureInfo studentLectureInfo) {
        return null;
    }

    @Override
    public StudentLectureInfo getByID(Long id) {
        return null;
    }

    @Override
    public Page<StudentLectureInfo> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}

package com.syrisa.studentservice.mapper;

import com.syrisa.studentservice.dto.StudentDto;
import com.syrisa.studentservice.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(target = "studentID", source = "student.studentID"),
            @Mapping(target = "studentName", source = "student.studentName"),
            @Mapping(target = "studentLastName", source = "student.studentLastName"),
            @Mapping(target = "studentGender", source = "student.studentGender"),
            @Mapping(target = "studentBirthDate", source = "student.studentBirthDate"),
            @Mapping(target = "address", source = "student.address")
    })
    StudentDto studentToStudentDto(Student student);


    @Mappings({
            @Mapping(target = "studentID", source = "studentDto.studentID"),
            @Mapping(target = "studentName", source = "studentDto.studentName"),
            @Mapping(target = "studentLastName", source = "studentDto.studentLastName"),
            @Mapping(target = "studentGender", source = "studentDto.studentGender"),
            @Mapping(target = "studentBirthDate", source = "studentDto.studentBirthDate"),
            @Mapping(target = "address", source = "studentDto.address")
    })
    Student studentDtoToStudent(StudentDto studentDto);
}

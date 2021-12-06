package com.syrisa.instructorlectureservice.utilities.checkobject;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PreCondition {
    public static <T> T checkNull(T resource){
        if (resource!=null)
            return resource;
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Not null");
    }
}

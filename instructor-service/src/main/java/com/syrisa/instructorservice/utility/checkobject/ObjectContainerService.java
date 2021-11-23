package com.syrisa.instructorservice.utility.checkobject;

import com.syrisa.instructorservice.entity.Entity;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectContainerService<T extends Entity> {

   public Predicate<T> isNull = Objects::nonNull;

}

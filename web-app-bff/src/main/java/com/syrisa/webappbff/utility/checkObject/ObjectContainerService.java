package com.syrisa.webappbff.utility.checkObject;


import com.syrisa.webappbff.entity.Entity;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectContainerService<T extends Entity> {

    public Predicate<T> isNull = Objects::nonNull;

}

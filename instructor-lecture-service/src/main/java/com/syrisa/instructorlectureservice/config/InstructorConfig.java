package com.syrisa.instructorlectureservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
@Configuration
public class InstructorConfig extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "blackhole";
    }

    @Override
    public String getPassword() {
        return "isasayar7?";
    }

    @Override
    public String getBucketName() {
        return "instructor_lec";
    }
}

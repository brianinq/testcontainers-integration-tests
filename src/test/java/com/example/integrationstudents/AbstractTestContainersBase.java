package com.example.integrationstudents;

import org.testcontainers.containers.MySQLContainer;

public abstract class AbstractTestContainersBase {
    static final MySQLContainer MY_SQL_CONTAINER;
    static {
        MY_SQL_CONTAINER = new MySQLContainer<>("mysql:latest");
        MY_SQL_CONTAINER.start();
    }
}

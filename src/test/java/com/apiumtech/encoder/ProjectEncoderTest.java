package com.apiumtech.encoder;

import static org.testng.Assert.*;

/**
 * Created by xavi on 7/13/16.
 */
public class ProjectEncoderTest {

    private ProjectEncoder sut;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        sut = new ProjectEncoder();

    }

    @org.testng.annotations.Test
    public void test_endodeProject() throws Exception {
        String projectPath = "";
        sut.encodeProject(projectPath);

    }
}
package com.apiumtech.encoder;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by root on 14/07/16.
 */
public class FileUtilsTest {

    private FileUtils sut;

    @BeforeMethod
    public void setUp() throws Exception {
        sut = new FileUtils();

    }

    @Test
    public void test_copyParsedTree_path_destination() throws Exception {

        String path = "/home/xavi.hidalgo/workspace/sandbox/utf-project-encoder/src/test/resources/folderTest";
        String dest = "/home/xavi.hidalgo/workspace/sandbox/utf-project-encoder/src/test/resources/folderTestDest";
        String actual = sut.copyParsedTree(path, dest);
        String expected = "";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test_getNewDestPathFromPath() throws Exception {
        String path = "/home/xavi.hidalgo/workspace/sandbox/utf-project-encoder/src/test/resources/folderTest/folderTest2/2.txt";
        String dest = "/home/xavi.hidalgo/workspace/sandbox/utf-project-encoder/src/test/resources/folderTestDest";

        String actual = sut.getNewDestPathFromPath(dest,path);

        String expected = "/home/xavi.hidalgo/workspace/sandbox/utf-project-encoder/src/test/resources/folderTestDest/folderTest/folderTest2/2.txt";
        Assert.assertEquals(actual,expected);
    }



    @Test
    public void test_PROCESS_REAL() throws Exception {

        String path = "/opt/workspaceIDEA/src/main/java";
        String dest = "/opt/workspaceIDEA/src/main/javaNEW";
        String actual = sut.copyParsedTree(path, dest);
        String expected = "";
        Assert.assertEquals(actual,expected);


    }
}

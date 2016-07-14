package com.apiumtech.encoder;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by xavi on 7/13/16.
 */
public class FileEncoderTest {

    private FileEncoder sut;
    private String resourcePath;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        sut = new FileEncoder();
        resourcePath = "/home/xavi.hidalgo/workspace/sandbox/utf-project-encoder/src/test/resources/";
    }

    @org.testng.annotations.Test
    public void testName() throws Exception {
        String actual = getStringFromFile();
        String expected = "some";
        Assert.assertTrue(actual.startsWith(expected));

    }

    private String getStringFromFile() throws IOException {

        String sourcePath = resourcePath + "ISO-8899-1_encoding_file.txt";
        String destPath = resourcePath + "destFile.txt";

        return sut.writeForcedUTF8file(sourcePath,destPath);
    }

    @Test
    public void test_getCharset() throws Exception {
        String str = getStringFromFile();
        String actual = sut.getCharset(str);
        String expected = "ISO-8859-2";
        Assert.assertEquals(actual,expected);

    }
}
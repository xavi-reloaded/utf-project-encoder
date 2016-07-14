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

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        sut = new FileEncoder();
    }

    @org.testng.annotations.Test
    public void testName() throws Exception {
        String actual = getStringFromFile();
        String expected = "asdfg";
        Assert.assertEquals(actual,expected);

    }

    private String getStringFromFile() throws IOException {
        String sourcePath = "/Users/xavi/workspace/__train/utf-project-encoder/src/test/resources/ISO-8899-1_encoding_file.txt";
        String destPath = "/Users/xavi/workspace/__train/utf-project-encoder/src/test/resources/destFile.txt";
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
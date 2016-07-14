package com.apiumtech.encoder;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by xavi on 7/13/16.
 */
public class FileEncoder {

    public String writeForcedUTF8file(String sourcePath, String destPath) throws IOException {

        FileInputStream fis = new FileInputStream(sourcePath);
        StringBuilder builder = new StringBuilder();

        int ch;
        while((ch = fis.read()) != -1){
            builder.append((char)ch);
        }

        String string = builder.toString();

        String charset1 = getCharset(string);
        Charset charset = Charset.forName(charset1);
        String in = new String(string.getBytes(charset), "UTF-8");
        DataOutputStream out = new DataOutputStream(new FileOutputStream(destPath));
        out.writeUTF(in);
        return in;
    }


    public String getCharset(String str) {
        CharsetDetector cd = new CharsetDetector();
        cd.setText(str.getBytes());
        CharsetMatch cm = cd.detect();
        return cm.getName();
    }
}

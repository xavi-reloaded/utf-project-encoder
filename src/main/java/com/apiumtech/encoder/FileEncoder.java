package com.apiumtech.encoder;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.*;
import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Created by xavi on 7/13/16.
 */
public class FileEncoder {

    public String writeForcedUTF8file(String sourcePath, String destPath) throws IOException {

        createDirs(destPath);

        FileInputStream fis = new FileInputStream(sourcePath);
        StringBuilder builder = new StringBuilder();

        int ch;
        while((ch = fis.read()) != -1){
            builder.append((char)ch);
        }

        String string = builder.toString();

        String charset1 = getCharset(string);

        Charset charset = (isValidCharset(charset1)) ? Charset.forName(charset1) : Charset.forName("UTF-8");


        String in = new String(string.getBytes(charset), "UTF-8");

        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destPath), "UTF-8"));
        try {
            out.write(in);
        } finally {
            out.close();
        }

//        DataOutputStream out = new DataOutputStream(new FileOutputStream(destPath));
//        out.writeUTF(in);


        return in;


    }

    public boolean isValidCharset(String charset1) {
        SortedMap<String, Charset> available = Charset.availableCharsets();
        for(String s : available.keySet()) {
            if (s.equals(charset1)) return true;
        }
        return false;
    }

    public void createDirs(String destPath) {


        String folderChain = destPath.substring(0,destPath.lastIndexOf("/"));
        File file = new File(folderChain);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    public String getCharset(String str) {
        CharsetDetector cd = new CharsetDetector();
        cd.setText(str.getBytes());
        CharsetMatch cm = cd.detect();
        return cm.getName();
    }
}

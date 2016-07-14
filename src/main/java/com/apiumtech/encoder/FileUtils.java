package com.apiumtech.encoder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

/**
 * Created by root on 14/07/16.
 */
public class FileUtils {



    public FileUtils() {

    }

    public String copyParsedTree(String path, String dest) throws IOException {

        new File(dest).mkdir();



        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach(join -> {
                    try {
                        process(join, dest);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


        return "";
    }

    private void process(Path path, String dest) throws IOException {
        FileEncoder encoder;
        encoder = new FileEncoder();
        String newFile = getNewDestPathFromPath(dest, path.toString());
        encoder.writeForcedUTF8file(path.toString(),newFile);
        System.out.println(newFile);

    }

    public String getNewDestPathFromPath(String dest, String path) {
        String[] splitted = dest.split("\\/");
        String prevFolder = splitted[splitted.length-2];
        String prefFolderInPath = path.split(prevFolder)[1];
        return dest  + prefFolderInPath;
    }
}

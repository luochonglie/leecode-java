package top.chonglie.tool;

import org.apache.tika.Tika;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileType {
    public static String getFileTypeByFilesProbeContentType(File file) {
        try {
            return Files.probeContentType(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFileTypeByURLConnectionGetContentType(File file) {
        try {
            URLConnection connection = file.toURI().toURL().openConnection();
            return connection.getContentType();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFileTypeByURLConnectionGuessContentTypeFromStream(File file) {
        try {
            return URLConnection.guessContentTypeFromStream(new BufferedInputStream(Files.newInputStream(file.toPath())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Tika tika = new Tika();

    public static String getFileTypeByTika(File file) {
        try {
            return tika.detect(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

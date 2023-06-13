package top.chonglie.tool;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.util.Collection;
import java.util.stream.Stream;

public class FileTypeTest {

    private static Collection<File> files;

    @BeforeAll
    static void BeforeAll() throws Exception {
        files = FileUtils.listFiles(new File(ClassLoader.getSystemResource("file_type_resources").toURI()), new String[]{"png", "jpg", "xlsx", "txt", "docx", "pdf"}, false);
    }

    @Test
    void testGetFileTypeByFilesProbeContentType() {
        files.forEach(f ->
                System.out.printf("%s : %s\n", f.getName(), FileType.getFileTypeByFilesProbeContentType(f))
        );
    }

    @Test
    void testGetFileTypeByURLConnectionGetContentType() {
        files.forEach(f ->
                System.out.printf("%s : %s\n", f.getName(), FileType.getFileTypeByURLConnectionGetContentType(f))
        );
    }

    @Test
    void testGetFileTypeByURLConnectionGuessContentTypeFromStream() {
        files.forEach(f ->
                System.out.printf("%s : %s\n", f.getName(), FileType.getFileTypeByURLConnectionGuessContentTypeFromStream(f))
        );
    }

    @Test
    void testGetFileTypeByTika() {
        files.forEach(f -> System.out.printf("%s : %s\n", f.getName(), FileType.getFileTypeByTika(f)));
    }
}

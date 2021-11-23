package top.chonglie;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * @program: leetcode-java
 * @description:
 * @author: c0l0121
 * @modified:
 * @create: 2021-11-23 18:10
 */
public class RenameTool {
    public static void main(String[] args) throws IOException {
        String path = "D:\\tmp\\change_file_name";
        String separator = ".";
        Collection<File> files = FileUtils.listFiles(new File(path), new String[]{"txt"}, false);

        for (File file : files) {
            System.out.println("From: " + file.getName() );
            System.out.println(Arrays.toString(file.getName().split(separator)));
            if(file.getName().split(separator)[0].length() < 3){
                String newFileName = "0" + file.getName();

                System.out.println("From: " + file.getName() + ", to: " + newFileName);
                FileUtils.moveFile(file, FileUtils.getFile(new File(path), newFileName));
            }
        }
    }
}

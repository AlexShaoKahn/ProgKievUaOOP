package com.shao.progkievua.homework2.lecture05;

import com.shao.progkievua.homework2.lecture05.filecopy.FileExtensions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public interface FileTools {

    static void fileCopy(File fromFile, File toFile) {
        try (FileInputStream fis = new FileInputStream(fromFile.toString());
             FileOutputStream fos = new FileOutputStream(toFile.toString())) {
            byte[] buffer = new byte[1024];
            int byteread;

            for (; (byteread = fis.read(buffer)) > 0; ) {
                fos.write(buffer, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (
//                InputStream in = new BufferedInputStream(new FileInputStream(fromFile));
//                OutputStream out = new BufferedOutputStream(new FileOutputStream(toFile))
//        ) {
//            byte[] buffer = new byte[1024];
//            int lengthRead;
//            while ((lengthRead = in.read(buffer)) > 0) {
//                out.write(buffer, 0, lengthRead);
//                out.flush();
//            }
//        }
    }

    static void fileCopy(String fromFileName, String toFileName) {
        fileCopy(new File(fromFileName), new File(toFileName));
    }

    static String[] copyAllFilesByExtension(String fromDirPath, String toDirPath, FileExtensions extension) {
        File fromDir = new File(fromDirPath);
        String[] filteredFiles = fromDir.list(((dir, name) -> name.endsWith("." + extension.name().toLowerCase())));
        if (filteredFiles != null)
            for (String filteredFile : filteredFiles) {
                fileCopy(fromDirPath + File.separator + filteredFile, toDirPath + File.separator + filteredFile);
            }
        return filteredFiles;
    }

    static String mergeFiles(String fileName1, String fileName2, String toFileName) throws IOException {
        String fileString1 = Files.readString(Paths.get(fileName1), StandardCharsets.UTF_8);
        String fileString2 = Files.readString(Paths.get(fileName2), StandardCharsets.UTF_8);
        List<String> splited1 = Arrays.asList(fileString1.replace("\n", "").split("[ \\t\\r,.–/()]", -1));
        List<String> splited2 = Arrays.asList(fileString2.replace("\n", "").split("[ \\t\\r,.–/()]", -1));
        StringBuilder result = new StringBuilder();
        for (String s : splited1) {
            if (!s.isEmpty() && !s.equals(" ") && splited2.contains(s)) result.append(s).append(" ");
        }
        Files.writeString(Paths.get(toFileName), result.toString());
        return result.toString();
    }
}

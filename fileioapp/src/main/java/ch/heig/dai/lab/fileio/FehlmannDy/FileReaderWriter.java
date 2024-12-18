package ch.heig.dai.lab.fileio.FehlmannDy;

import java.io.BufferedReader;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.
        try {
            var reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), encoding
                    )
            );

            StringBuilder reading = new StringBuilder();

            while ((reader.readLine()) != null) {
                reading.append(reader.readLine());
            }

            reader.close();
            return reading.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Write the content to a file with a given encoding. 
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        try (var writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file), encoding)
        )
        ) {
            writer.write(content);
            writer.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}

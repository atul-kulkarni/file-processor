package com.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileProcessor {

  public void reverseContents(final String inputFileName, final String outputFileName)
      throws IOException {
    InputStream inputStream = getInputStream(inputFileName);
    OutputStream outputStream = getOutStream(outputFileName);
    reverseContents(inputStream, outputStream);
  }

  public InputStream getInputStream(String inputFileName) throws FileNotFoundException {
    return new FileInputStream(inputFileName);
  }

  public OutputStream getOutStream(String outputFileName) throws FileNotFoundException {
    return new FileOutputStream(outputFileName);
  }

  public void reverseContents(final InputStream inputStream, final OutputStream outputStream)
      throws IOException {
    String inputFileContents = readInputFile(inputStream);
    String reverseContent = reverseContent(inputFileContents);
    writeOutputFile(outputStream, reverseContent);
  }

  public String readInputFile(final InputStream inputStream) throws IOException {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line);
      }
    }
    return content.toString();
  }

  public String reverseContent(final String content) {
    return new StringBuilder(content).reverse().toString();
  }

  public void writeOutputFile(final OutputStream outputStream, final String content)
      throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
      writer.write(content);
    }
  }
}

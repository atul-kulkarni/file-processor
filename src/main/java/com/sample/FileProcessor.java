package com.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileProcessor {

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

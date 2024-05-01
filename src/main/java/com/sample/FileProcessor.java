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

/** To perform various operations on files such as reversing the contents of the file. */
public class FileProcessor {

  /**
   * To reverse the contents based on file names (Option 1)
   *
   * @param inputFileName input file name from where contents to be read
   * @param outputFileName output file name to where reversed contents to be written
   * @throws IOException IOException
   */
  public void reverseContents(final String inputFileName, final String outputFileName)
      throws IOException {
    InputStream inputStream = getInputStream(inputFileName);
    OutputStream outputStream = getOutStream(outputFileName);
    reverseContents(inputStream, outputStream);
  }

  /**
   * To reverse the contents based on streams (Option 2)
   *
   * @param inputStream input stream
   * @param outputStream output stream
   * @throws IOException IOException
   */
  public void reverseContents(final InputStream inputStream, final OutputStream outputStream)
      throws IOException {
    String inputFileContents = readInputStream(inputStream);
    String reverseContent = reverseContent(inputFileContents);
    writeToOutputStream(outputStream, reverseContent);
  }

  /**
   * To read file contents from input stream
   *
   * @param inputStream input stream
   * @return file contents read from input stream
   * @throws IOException IOException
   */
  public String readInputStream(final InputStream inputStream) throws IOException {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line);
      }
    }
    return content.toString();
  }

  /**
   * Reverse the contents
   *
   * @param content to be reversed
   * @return reversed contetns
   */
  public String reverseContent(final String content) {
    return new StringBuilder(content).reverse().toString();
  }

  /**
   * Write contents to output stream
   *
   * @param outputStream output stream
   * @param content contents to be written
   * @throws IOException IOException
   */
  public void writeToOutputStream(final OutputStream outputStream, final String content)
      throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
      writer.write(content);
    }
  }

  /**
   * Get input stream based on file name
   *
   * @param inputFileName input file name
   * @return input stream
   * @throws FileNotFoundException FileNotFoundException
   */
  public InputStream getInputStream(String inputFileName) throws FileNotFoundException {
    return new FileInputStream(inputFileName);
  }

  /**
   * Get output stream
   *
   * @param outputFileName output file name
   * @return output stream
   * @throws FileNotFoundException FileNotFoundException
   */
  public OutputStream getOutStream(String outputFileName) throws FileNotFoundException {
    return new FileOutputStream(outputFileName);
  }
}

package com.sample;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileProcessorTest {

  @Test
  void testReadInputFile() throws IOException {

    // Arrange
    InputStream inputStream = new ByteArrayInputStream("ABC".getBytes());
    FileProcessor fileProcessor = new FileProcessor();

    // Act
    String content = fileProcessor.readInputFile(inputStream);

    // Assert
    assertEquals("ABC", content);
  }

  @Test
  void testReverseContent() {
    FileProcessor fileProcessor = new FileProcessor();
    String reversed = fileProcessor.reverseContent("ABC");
    assertEquals("CBA", reversed);
  }

  @Test
  void testWriteOutputFile() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    FileProcessor fileProcessor = new FileProcessor();
    String reversedContent = "CBA";

    // Act
    fileProcessor.writeOutputFile(outputStream, reversedContent);

    // Assert
    assertEquals(reversedContent, outputStream.toString());
  }
}

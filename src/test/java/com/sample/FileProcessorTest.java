package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FileProcessorTest {

  @Test
  void testReadInputStream() throws IOException {
    // Arrange
    InputStream inputStream = new ByteArrayInputStream("ABC".getBytes());
    FileProcessor fileProcessor = new FileProcessor();

    // Act
    String content = fileProcessor.readInputStream(inputStream);

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
  void testWriteToOutputStream() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    FileProcessor fileProcessor = new FileProcessor();
    String reversedContent = "CBA";

    // Act
    fileProcessor.writeToOutputStream(outputStream, reversedContent);

    // Assert
    assertEquals(reversedContent, outputStream.toString());
  }

  @Test
  void testReverseContentBasedOnStreams() throws IOException {
    // Arrange
    InputStream inputStream = new ByteArrayInputStream("ABC".getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    FileProcessor fileProcessor = new FileProcessor();

    // Act
    fileProcessor.reverseContents(inputStream, outputStream);

    // Assert
    assertEquals("CBA", outputStream.toString());
  }

  @Test
  void testReverseContentBasedOnFileNames() throws IOException {
    // Arrange
    InputStream inputStream = new ByteArrayInputStream("ABC".getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    FileProcessor fileProcessor = Mockito.spy(new FileProcessor());
    doReturn(inputStream).when(fileProcessor).getInputStream(Mockito.anyString());
    doReturn(outputStream).when(fileProcessor).getOutStream(Mockito.anyString());

    // Act
    fileProcessor.reverseContents("input.txt", "output.txt");

    // Assert
    assertEquals("CBA", outputStream.toString());
    verify(fileProcessor).getInputStream("input.txt");
    verify(fileProcessor).getOutStream("output.txt");
  }
}

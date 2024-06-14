package com.parsakav.bookstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parsakav.bookstore.dto.BookDTO;
import com.parsakav.bookstore.entity.BookEntity;
import com.parsakav.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController {

    @Autowired
    private BookService bookService;


    //@Value("${upload.dir}")
    private String uploadDir = System.getProperty("java.io.tmpdir");

    @PostMapping(consumes = {"multipart/form-data"})
    public BookDTO.Output addBook(@RequestPart("book") String bookDTOString,
                                  @RequestPart("bookimg") MultipartFile bookimg) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        BookDTO.Input bookDTO = objectMapper.readValue(bookDTOString, BookDTO.Input.class);
        String bookImgName = bookimg.getOriginalFilename();
        Path path = Paths.get(uploadDir + bookImgName);
        Files.createDirectories(path.getParent());

        Files.write(path, bookimg.getBytes());
        BookEntity bookEntity = BookDTO.Input.mapping(bookDTO);
        bookEntity.setBookimg(bookImgName);
        BookEntity savedEntity = bookService.addBook(bookEntity);

        return BookDTO.Output.mapping(savedEntity);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/image", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(@RequestParam("filename") String fileName) throws IOException {
        File file = new File(uploadDir + fileName);
        FileSystemResource resource = new FileSystemResource(file);

        if (!file.exists() || !file.canRead()) {
            throw new IOException("File not found or not readable: " + fileName);
        }

        String contentType = "image/jpeg"; // Change this to match the actual image type (e.g., image/png)
        if (fileName.toLowerCase().endsWith(".png")) {
            contentType = "image/png";
        } else if (fileName.toLowerCase().endsWith(".gif")) {
            contentType = "image/gif";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .contentLength(file.length())
                .body(resource);
    }

    @PreAuthorize("permitAll()")

    @GetMapping
    public List<BookDTO.Output> getAllBooks() {
        return BookDTO.Output.mapping(bookService.getAllBooks());
    }
}

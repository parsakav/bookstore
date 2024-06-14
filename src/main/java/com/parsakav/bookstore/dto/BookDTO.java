package com.parsakav.bookstore.dto;

import com.parsakav.bookstore.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BookDTO {


    @Getter
    @Setter

    public static class Input {
        private String author;
        private String title;
        private String isbn;
        private String description;
        private String tag;
        private int price;
        private int stock;

        public static BookEntity mapping(Input bookEntity) {
            BookEntity user = new BookEntity();
            BeanUtils.copyProperties(bookEntity, user);
            // user.setBookImgUrl("/uploads/" + bookEntity.getBookimg()); // Set the image URL

            return user;
        }

        public static List<BookEntity> mapping(List<Input> bookEntities) {
            return bookEntities.stream().map(Input::mapping).collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    public static class Output {
        private String author;
        private String title;
        private String isbn;
        private String description;
        private String tag;
        private int price;
        private int stock;
        private String bookImgUrl; // Added field for image URL

        public static Output mapping(BookEntity bookEntity) {
            Output user = new Output();
            BeanUtils.copyProperties(bookEntity, user);
            user.setBookImgUrl(/*"src/main/resources/static/uploads/" +*/ bookEntity.getBookimg()); // Set the image URL

            return user;
        }

        public static List<Output> mapping(List<BookEntity> bookEntities) {
            return bookEntities.stream().map(Output::mapping).collect(Collectors.toList());

        }
    }

    public static class Filter {
        private int offset;
        private int size;
        private boolean desc = true;

   }
   public static class Pagination{
       private long total;

   }
}

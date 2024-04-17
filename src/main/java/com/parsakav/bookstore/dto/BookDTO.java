package com.parsakav.bookstore.dto;

import com.parsakav.bookstore.entity.BookEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookDTO {
   public static class Input{
       public static BookEntity mapping(Input bookEntity){
           return null;
       }
       public static List<BookEntity> mapping(List<Input> bookEntities){
           return bookEntities.stream().map(Input::mapping).collect(Collectors.toList());
       }
   }
   public static class Output{
       public static Output mapping(BookEntity bookEntity){
          return null;
       }
       public static List<Output> mapping(List<BookEntity> bookEntities){
return bookEntities.stream().map(Output::mapping).collect(Collectors.toList());
       }
   }
   public static class Filter{
       private int offset;
       private int size;
       private boolean desc=true;

   }
   public static class Pagination{
       private long total;

   }
}

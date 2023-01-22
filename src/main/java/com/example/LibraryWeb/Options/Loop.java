package com.example.LibraryWeb.Options;


import com.example.LibraryWeb.Book.BookDto;
import com.example.LibraryWeb.Book.BookDtoSaveBook;
import com.example.LibraryWeb.Book.BookRepository;
import com.example.LibraryWeb.Book.BookServices;
import com.example.LibraryWeb.Person.PersonServices;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service

public class Loop {
    private final BookServices bookServices;
    private final PersonServices personServices;
    private final BookRepository bookRepository;
    private final Scanner scanner;


    public Loop(BookServices bookServices, PersonServices personServices, BookRepository bookRepository, Scanner scanner) {
        this.bookServices = bookServices;
        this.personServices = personServices;
        this.bookRepository = bookRepository;
        this.scanner = scanner;
    }

    public void loop() {
        Options options;
        options = Options.createOptions(scanner.nextInt());
        do {
            printOptions();


            switch (options) {
                case ADD -> bookServices.saveBook(saveBook());


            }

        } while (options != Options.EXIT);
    }



      private void  printOptions(){
          System.out.println("Wybierz opcje");
          for (Options o:Options.values()
               ) {
              System.out.println(o);

          }
      }
    private   BookDtoSaveBook saveBook(){
          System.out.println("Podaj nazwe ksiazki");
          String bookName=scanner.nextLine();
          System.out.println("Podaj autora");
          String author =scanner.nextLine();
          System.out.println("Podaj isbn");
          String  isbn=scanner.nextLine();
          return new BookDtoSaveBook(bookName,author,isbn);

      }



}

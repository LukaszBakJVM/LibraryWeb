package com.example.LibraryWeb.Options;

public enum Options {

        EXIT(0,"Wyjscie"),ADD(1,"Dodaj ksiazke"),RENT(2,"Wypozycz ksiazke")
        , RETURN_BOOK(3,"Zwrot ksiazki"),PRINT_ALL_BOOKS(4,"Wyswietl wszystkie ksiazki"),
        PRINT_ALL_AVAILABLE_BOOKS(5,"Wyswietl wszystkie dostepne ksiazki")
        ,PRINT_ALL_NOT_AVAILABLE_BOOKS(6,"Wyswietl wszystkie wyporzyczone ksiazki")
        ,DELETE_BOOK(7,"Usun ksiazke");
        final private int option;
        final private String descryption;

        Options(int option, String description) {
            this.option = option;
            this.descryption = description;
        }

        @Override
        public String toString() {
            return option +"-->"+
                    descryption ;
        }

        public static Options createOptions(int opt){
            return Options.values()[opt];
        }

}

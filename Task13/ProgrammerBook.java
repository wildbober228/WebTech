package com.wildbober.Task13;

import com.wildbober.Task12.Book;

import java.util.Objects;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (!super.equals(object)) {
            return false;
        }

        ProgrammerBook programmerBook = (ProgrammerBook) object;
        return level == programmerBook.level &&
                language.equals(programmerBook.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), language, level);
    }

    @Override
    public String toString() {
        return "ProgrammerBook "+super.getTitle()
                + " Author" + super.getAuthor()
                + " Price" + super.getPrice()
                + " Language" + language
                + "Level " + level;
    }
}

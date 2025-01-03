package DesignPatterns.BehavioralDP.Strategy;

import java.util.Vector;

interface ISortStrategy {
    Vector sort(Vector items);
}

class Book {
    private String lastName;

    public String getLastName() {
        return lastName;
    }
}

class Library {
    private ISortStrategy sortStrategy;
    private Vector<Book> Books;

    public Library(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
        Books = new Vector<>();
    }

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public Vector<Book> searchByAuthor(String name) {
        Vector<Book> results = new Vector<>();
        for (int i = 0; i < Books.size(); i++) {
            Book book = Books.elementAt(i);
            String authorLastName = book.getLastName();
            if ((authorLastName.indexOf(name) != -1))
                results.addElement(book);
        }
        sortStrategy.sort(results);
        return results;

    }
}

class SortingBooksStrategy implements ISortStrategy {
    @Override
    public Vector sort(Vector items) {
        // applying sorting
        return items;
    }
}

class SelectionSorter implements ISortStrategy {
    @Override
    public Vector sort(Vector items) {
        // applying sorting
        return items;
    }
}

package com.sda.service.bookstore;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BookstoreSteps {

    private Bookstore bookstore;
    private Book book;

    @Given("^I instantiate bookstore$")
    public void i_instantiate_bookstore(){
        this.bookstore = new Bookstore();
    }

    @And("^I create a book$")
    public void i_create_a_book() {
    this.book = new Book("Ogniem i mieczem", "Henryk Sienkiewicz", "qwerty23", 1500100900);
    }

    @When("^I add book to bookstore$")
    public void i_add_book_to_bookstore() {
        this.bookstore.add(this.book);
    }

    @Then("^Book is present in bookstore$")
    public void book_is_present_in_bookstore() {
        Assert.assertEquals(1, this.bookstore.getBooks().size());

    }

    @And("^I update book's title$")
    public void i_update_books_title() {
        bookstore.updateTitle(book, "Totalne dno");
    }

    @Then("^Book's title in bookstore is updated$")
    public void books_title_in_bookstore_is_updated() {
        Assert.assertEquals("Totalne dno", bookstore.getBooks().get(0).getTitle());
    }
}

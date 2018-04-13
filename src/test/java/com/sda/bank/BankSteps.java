package com.sda.bank;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.mockito.Mockito;

public class BankSteps {
        private Bank bank;
        private BankUser bankUser;
        private BankAccount account;
        private BankDatabase bankDatabase = new BankDatabase();
        private boolean userInsertResult;
        private boolean accountCreationResult;
        private boolean depositResult;

        @Given("^I instantiate bank$")
        public void iInstantiateBank() {
            this.bank = new Bank(bankDatabase);
        }

        @And("^I create user with name '(.*)' and pesel '(.*)'$")
        public void iCreateUserWithNameAndPesel(String name, String pesel) {
            this.bankUser = new BankUser(name, pesel);
        }

        @And("^I add user to bank$")
        public void iAddUserToBank() {
            userInsertResult = bank.addBankUser(new BankUser(bankUser.getName(), bankUser.getPesel()));
        }

        @Then("^User is present in bank$")
        public void userIsPresentInBank() {
            Assert.assertTrue(userInsertResult);
            Assert.assertEquals(1, bank.numberOfUsers());
        }

        @Then("^Cannot add the same user to bank$")
        public void cannotAddTheSameUserToBank() {
            Assert.assertFalse(userInsertResult);
            Assert.assertEquals(1, bank.numberOfUsers());

        }


        @Then("^Account is present in bank$")
        public void accountIsPresentInBank() {
            Assert.assertTrue(accountCreationResult);
            Assert.assertEquals(1, bank.numberOfAccounts());
        }

        @And("^I create account with name '(.*)'$")
        public void iCreateAccountWithNameName(String nameOfAccount) {
            this.account = new BankAccount(nameOfAccount);
        }

        @And("^I insert account to bank$")
        public void iInsertAccountToBank() {
            accountCreationResult = bank.createAccountFor(bankUser, this.account.getId());
        }

        @Then("^Account is not present in bank$")
        public void accountIsNotPresentInBank() {
            Assert.assertFalse(accountCreationResult);
            Assert.assertEquals(0, bank.numberOfAccounts());
        }

        @Then("^User has only '(\\d+)' account in bank$")
        public void userHasOnlyAccountInBank(int numberOfAccounts) {
            Assert.assertEquals(numberOfAccounts, bank.getAccountsOf(bankUser).size());
        }

        @And("^I deposit '(\\d+)' to account with name \"([^\"]*)\"$")
        public void iDepositToAccountWithName(int amount, String nameOfAccount) {
            this.depositResult = bank.deposit(nameOfAccount, amount);}


        @Then("^Account with name \"([^\"]*)\" has amount of '(\\d+)'$")
        public void accountWithNameHasAmountOf(String nameOfAccount, int amount) {
          Assert.assertTrue(depositResult);
          Assert.assertEquals(amount, bank.getAccountWithId(nameOfAccount).getAmount());
        }

        @Given("^I mock bank database for this case$")
        public void iMockBankDatabaseForThisCase() {
            this.bankDatabase = Mockito.mock(BankDatabase.class);
            Mockito.when(bankDatabase.addBankUser(Mockito.any())).then(e -> true);
            Mockito.when(bankDatabase.createAccountFor(Mockito.any(), Mockito.anyString())).then(e -> true);
            Mockito.when(bankDatabase.getAccountWithId(Mockito.anyString())).then(e -> BankAccount.instanceOf(null, 1000));
            Mockito.when(bankDatabase.deposit(Mockito.anyString(), Mockito.anyInt())).then(e -> true);
        }

    //    @Then("^User has only '(\\d+)' account named \"([^\"]*)\" in bank$")
    //    public void userHasOnlyAccountNamedInBank(int number, String nameOfAccount){
    //        Assert.assertEquals(1, bank.getAccountsOf(bankUser.));}


}

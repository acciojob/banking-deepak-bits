package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        CurrentAccount currentAccount = new CurrentAccount("curr", 10000.0, "AAAAAAAABBBCCC");
        System.out.println(currentAccount.isStringValid(currentAccount.getTradeLicenseId()));
        currentAccount.validateLicenseId();
//        SavingsAccount savingsAccount = new SavingsAccount("AccioJob", 10000.0, 500.0, 10.0);
//        System.out.println("Simple Interest after 10 years is " + savingsAccount.getSimpleInterest(10));
//        System.out.println("Compound Interest after 2 years at 1 times per year is " + savingsAccount.getCompoundInterest(1, 2));
//        Double val1 = 12100.000000000002;
//        System.out.println(val1.equals(savingsAccount.getCompoundInterest(1, 2)));
    }
}
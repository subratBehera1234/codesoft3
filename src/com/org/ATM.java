package com.org;

import java.util.Scanner;

public class ATM {

	private BankAccount account;
	
	public ATM(BankAccount account) {
		this.account=account;
	}
	
	public void display() {
		System.out.println("----------ATM MENU----------");
		System.out.println("1) Withdraw");
		System.out.println("2) Deposit");
		System.out.println("3) Check Balance");
		System.out.println("4) Exit");
		
		System.out.println("Enter Your Choice :");
		
	}
	
	public void operation(int ch) {
		switch (ch) {
		case 1:
			withdraw();
			break;
		case 2:
			deposit();
			break;
		case 3:
			checkBalance();
			break;
		case 4:
			System.out.println("Thank you for using ATM..");
			break;

		default:
			System.out.println("Invalid choice. Please Enter Enter A Valid Choice");
			break;
		}
	}



	private void withdraw() {
		System.out.println("Enter Amount To Withdraw : ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		if(account.withdraw(amount)) {
			System.out.println("Amount withdrawn successfully");
		}
		else {
			System.out.println("Insufficient balance");
		}
		
	}

	private void deposit() {
		System.out.println("Enter Amount To Deposit : ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		account.deposit(amount);
		System.out.println("Deposit successful. Your balance is : "+account.getBalance());
	}
	
	private void checkBalance() {
		System.out.println("Your current balance is : "+account.getBalance());
		
	}
	
	public static void main(String[] args) {
		BankAccount account=new BankAccount(1000);
		ATM atm=new ATM(account);
		
		while(true) {
			atm.display();
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			atm.operation(ch);
			if(ch==4) {
				break;
			}
		}
	
	}

	
}

class BankAccount{
	
	private double balance;
	
	public BankAccount(double balance) {
		this.balance=balance;
		
	}

	public double getBalance() {
		return balance;
	}
	
	public boolean withdraw(double amount) {
		
		if(balance>=amount) {
			balance=balance-amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void deposit(double amount) {
		balance=balance+amount;
	}
	
}

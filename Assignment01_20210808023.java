//@author: Ozge Havva Sahin @date= 15/03/2022

import java.util.Random;

public class Assignment01_20210808023{
    public static void main(String[] args) {
        Account a = new Account("1234",100);
        PersonalAccount pa = new PersonalAccount("9876", "Joseph", "Ledet");
        BusinessAccount ba = new BusinessAccount("5678",1000,0.09);
        Customer cu = new Customer("John", "Smith");
        Company co = new Company("Akdeniz Universitesi");
        
        a.withdrawal(50);
        System.out.println(a);
        pa.deposit(150);
        System.out.println(pa);
        System.out.println("PIN is " + pa.getPIN());
        ba.deposit(ba.calculateInterest());
        System.out.println(ba);
        ba.withdrawal(100);
        System.out.println(ba);

        System.out.println(cu);
        cu.openAccount("3456");
        cu.getAccount().deposit(123);
        System.out.println(cu.getAccount());

        System.out.println(co);
        co.openAccount("6543", 0.05);
        co.getAccount().deposit(321);
        System.out.println(co.getAccount());
        
    }
}

class Account{
    private String acctNum;
    private double balance;
    public Account(String acctNum){
        this.acctNum = acctNum;
        this.balance = 0;
    }
    public Account(String acctNum , double balance){
        this.acctNum = acctNum;
        if(balance < 0){
            this.balance = 0;
        }else{
            this.balance = balance;
        }
    
    }
    public String getAcctNum() {
        return acctNum;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;   
        }
    }
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }
    public void withdrawal(double amount){ 
        if(amount > 0 && amount <= balance){
            this.balance -= amount;
        }
    }
    public String toString(){
        return "Account " + acctNum + " has " + balance ;
    }
}

class PersonalAccount extends Account{
    private String name,surname,PIN;
    public PersonalAccount(String acctNum, String name,String surname){
        super(acctNum);
        this.name = name;
        this.surname = surname;
        java.util.Random rand = new Random();
        this.PIN = Integer.toString(rand.nextInt(1000,9999));
    }
    public PersonalAccount(String acctNum, String name,String surname,double balance){
        this(acctNum, name, surname);
        setBalance(balance);
    }
    public String toString(){
        return "Account " + getAcctNum() + " belonging to " + name + " " + surname.toUpperCase() + " has " + getBalance(); 
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPIN() {
        return PIN;
    }
    public void setPIN(String pIN) {
        this.PIN = pIN;
    }
}

class BusinessAccount extends Account{
    private double rate;
    public BusinessAccount( String acctNum,double rate){
        super(acctNum);
        this.rate = rate;
    }
    public BusinessAccount( String acctNum,double balance,double rate){
        super(acctNum,balance);
        this.rate = rate;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double calculateInterest(){
        return getBalance()*this.rate;
    }

}
class Customer{
    private String name,surname;
    private PersonalAccount pa;
    public Customer(String name,String surname){
        this.name = name;
        this.surname = surname;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void openAccount(String acctNum){
        pa =new PersonalAccount(acctNum, this.name, this.surname , 0);
    }
    PersonalAccount getAccount(){
        return pa;
    }
    public String toString(){
        return name + " " + surname.toUpperCase();
    }
}
class Company{
    private String name;
    private BusinessAccount ba;
    public Company(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void openAccount( String acctNum, double rate){
        ba = new BusinessAccount(acctNum, 0, rate);
    }
    public BusinessAccount getAccount(){
        return ba;
    }
    public String toString(){ 
        return name;
    }
}
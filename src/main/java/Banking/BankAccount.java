package Banking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final int id;
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(int id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId(){
        return  id;
    }
    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void deposit(int amount) {
        lock.lock();
        balance += amount;
        lock.unlock();
        System.out.println(amount + " deposited to the account " + getId() + "\n balance is " + balance);
    }

    public void withdraw(int amount) {
        lock.lock();
        balance -= amount;
        lock.unlock();
        System.out.println(amount + " withdrawn from the account " + getId() + "\n balance is " + balance);
    }

    public void transfer(BankAccount target, int amount) {
        if(target.getId() < this.getId())
        {
            lock.lock();
            target.getLock().lock();
            target.getLock().unlock();
            lock.unlock();
        }
        else
        {
            target.getLock().lock();
            lock.lock();
            target.getLock().unlock();
            lock.unlock();
        }

        balance -= amount;
        target.balance += amount;

        System.out.println("Transfer from the account " + getId() + " to account " + target.getId()
                + "\n" + amount + "transferred" + "\n balance is " + balance);


    }
}
package MultiThreading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//https://leetcode.com/problems/fizz-buzz-multithreaded/

/*
* Write a program that outputs the string representation of numbers from 1 to n, however:

    If the number is divisible by 3, output "fizz".
    If the number is divisible by 5, output "buzz".
    If the number is divisible by both 3 and 5, output "fizzbuzz".

For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

Suppose you are given the following code:

class FizzBuzz {
  public FizzBuzz(int n) { ... }               // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}

Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:

    Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
    Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
    Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
    Thread D will call number() which should only output the numbers.

* */

class FizzBuzz {
    private int n;

    Semaphore fizz;
    Semaphore buzz;
    Semaphore fizzBuzz;
    Semaphore num ;
    int i =1;

    public FizzBuzz(int n) {
        this.n = n;
        this.fizz = new Semaphore(0);
        this.buzz = new Semaphore(0);
        this.fizzBuzz = new Semaphore(0);
        this.num = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".

    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            fizz.acquire();

            if(i > n)
                break;

            printFizz.run();
            i++;
            num.release();
        }


    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            buzz.acquire();

            if(i > n)
                break;

            printBuzz.run();
            i++;
            num.release();
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            fizzBuzz.acquire();

            if(i > n)
                break;

            printFizzBuzz.run();
            i++;
            num.release();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true){

            num.acquire();
            if(i > n){
                fizzBuzz.release();
                buzz.release();
                fizz.release();
                //num.release();
                break;
            }

            if(i % 3 ==0 && i % 5== 0){
                fizzBuzz.release();
            }else if(i % 5 ==0){
                buzz.release();
            }else if(i % 3 ==0){
                fizz.release();
            }else{
                //System.out.println(i);
                printNumber.accept(i);
                i++;
                num.release();
            }

        }

    }
}

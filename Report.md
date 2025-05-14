**Question 1a:** What output do you get from the program? Why?

**Answer:**
1. `atomicCounter:`
Since AtomicInteger is used, which performs operations atomically, this counter will always maintain correct and consistent values in multi-threaded conditions. In the end, the atomicCounter should reach exactly 2 million (because each of the two threads increments the counter 1 million times).

2. `normalCounter:`
The normalCounter variable is a regular int, and operations on it are performed without locking. In concurrent execution without proper synchronization mechanisms (such as synchronized or AtomicInteger), this counter can experience thread-safety issues. In other words, some increments may be lost (meaning two threads might simultaneously read the counter's value, increment it, and then store the new value, leading to reduced accuracy).

Then outputs are :
Atomic Counter: 2000000
Normal Counter: less than 2000000

**Question 1b:** What is the purpose of AtomicInteger in this code?

**Answer:**
To prevent concurrency issues when incrementing a counter across multiple threads and ensure thread-safe increment operations in a multi-threaded environment, we use AtomicInteger.

**Question 1c:** What thread-safety guarantees does atomicCounter.incrementAndGet() provide?

**Answer:**
The atomicCounter.incrementAndGet() method guarantees that incrementing the counter value in a multi-threaded environment is performed in a completely safe and error-free manner, without requiring locks or synchronized blocks.

**Question 1d:** In which situations would using a lock be a better choice than an atomic variable?

**Answer:**
Atomic variables are excellent for simple, fast operations (like incrementing a number).
However, when you need to:

1. Modify multiple variables simultaneously,

2. Implement complex conditional logic,

3. Or maintain precise control over thread execution,

Locks are a better choice as they provide greater flexibility and control.

**Question 1e:** Besides AtomicInteger, what other data types are available in the java.util.concurrent.atomic package?

**Answer:**
1. AtomicLong
2. AtomicBoolean
3. AtomicIntegerArray
4. AtomicLongArray
5. AtomicReference<V>
6. AtomicStampedReference<V>
7. AtomicMarkableReference<V>



# Exercise 40: Virtual Threads

**Note:** Requires JDK 21!
Try doing this with `new Thread(Runnable).start()`. The JVM will crash instantly from running out of memory. Virtual threads multiplex onto carrier threads, meaning they use virtually zero RAM while sleeping/waiting!

# Exercise 33: Transaction Handling in JDBC

Disables `setAutoCommit(false)`, attempts to move money between accounts, and calls `commit()`. If an exception occurs during the process, it hits the `catch` block and runs `rollback()` to ensure no money is lost into the void.

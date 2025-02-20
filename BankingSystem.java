import java.util.*;

// Class representing a withdrawal request.
class WithdrawalRequest {
    private String accountNumber;
    private double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "WithdrawalRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}

// Banking system implementation
public class BankingSystem {
    // HashMap: AccountNumber -> Balance.
    private Map<String, Double> accounts = new HashMap<>();
    
    // TreeMap: Balance -> List of Account Numbers. This ensures the keys (balances) are sorted.
    private TreeMap<Double, List<String>> accountsByBalance = new TreeMap<>();
    
    // Queue to process withdrawal requests.
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add a new account.
    public void addAccount(String accountNumber, double balance) {
        // Add to HashMap.
        accounts.put(accountNumber, balance);
        // Add to TreeMap.
        addToTreeMap(accountNumber, balance);
    }

    // Helper method to add an account to the TreeMap.
    private void addToTreeMap(String accountNumber, double balance) {
        accountsByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }
    
    // Helper method to remove an account from the TreeMap using the old balance.
    private void removeFromTreeMap(String accountNumber, double oldBalance) {
        List<String> accountList = accountsByBalance.get(oldBalance);
        if (accountList != null) {
            accountList.remove(accountNumber);
            if (accountList.isEmpty()) {
                accountsByBalance.remove(oldBalance);
            }
        }
    }
    
    // Update an account balance (e.g. deposit or withdrawal).
    public void updateBalance(String accountNumber, double newBalance) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account " + accountNumber + " does not exist.");
            return;
        }
        double oldBalance = accounts.get(accountNumber);
        // Update in HashMap.
        accounts.put(accountNumber, newBalance);
        // Update in TreeMap.
        removeFromTreeMap(accountNumber, oldBalance);
        addToTreeMap(accountNumber, newBalance);
    }
    
    // Deposit amount into an account.
    public void deposit(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Deposit failed. Account " + accountNumber + " not found.");
            return;
        }
        double newBalance = accounts.get(accountNumber) + amount;
        updateBalance(accountNumber, newBalance);
        System.out.println("Deposited $" + amount + " into account " + accountNumber + ". New balance: $" + newBalance);
    }
    
    // Initiate a withdrawal by adding a request to the queue.
    public void requestWithdrawal(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Withdrawal request failed. Account " + accountNumber + " not found.");
            return;
        }
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request enqueued: " + accountNumber + " for $" + amount);
    }
    
    // Process all withdrawal requests from the queue.
    public void processWithdrawalRequests() {
        System.out.println("\nProcessing withdrawal requests...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            String acc = req.getAccountNumber();
            double amount = req.getAmount();
            double currentBalance = accounts.get(acc);
            
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                updateBalance(acc, newBalance);
                System.out.println("Processed withdrawal for account " + acc + ": $" + amount +
                                   ". New balance: $" + newBalance);
            } else {
                System.out.println("Insufficient funds for account " + acc +
                                   ". Requested: $" + amount + ", Available: $" + currentBalance);
            }
        }
    }
    
    // Display all accounts with balances from the HashMap.
    public void displayAccounts() {
        System.out.println("\n--- All Accounts ---");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " | Balance: $" + entry.getValue());
        }
    }
    
    // Display accounts sorted by balance from the TreeMap.
    public void displayAccountsSortedByBalance() {
        System.out.println("\n--- Accounts Sorted by Balance ---");
        for (Map.Entry<Double, List<String>> entry : accountsByBalance.entrySet()) {
            double balance = entry.getKey();
            List<String> accountNumbers = entry.getValue();
            for (String account : accountNumbers) {
                System.out.println("Account: " + account + " | Balance: $" + balance);
            }
        }
    }
    
    // Main method to demonstrate the Banking System.
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        // Create some customer accounts.
        bank.addAccount("ACC1001", 5000.00);
        bank.addAccount("ACC1002", 3000.00);
        bank.addAccount("ACC1003", 7500.00);
        bank.addAccount("ACC1004", 3000.00); // Note: duplicate balance to see multiple accounts per balance.
        
        // Display all accounts.
        bank.displayAccounts();
        bank.displayAccountsSortedByBalance();
        
        // Process a deposit.
        bank.deposit("ACC1002", 1500.00);
        
        // Request withdrawals.
        bank.requestWithdrawal("ACC1001", 2000.00);
        bank.requestWithdrawal("ACC1003", 8000.00); // This should show insufficient funds.
        bank.requestWithdrawal("ACC1004", 1000.00);
        
        // Process withdrawal queue.
        bank.processWithdrawalRequests();
        
        // Display updated accounts.
        bank.displayAccounts();
        bank.displayAccountsSortedByBalance();
    }
}

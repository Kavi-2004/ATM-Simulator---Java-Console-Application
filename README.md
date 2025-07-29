# 💳 ATM Simulator – Java Console Application

This project is a console-based **ATM Simulation** system implemented in **Java**, demonstrating key object-oriented programming concepts such as encapsulation, inheritance, and modular design. It mimics a basic ATM system with enhanced security and smart banking features.

---

### ✅ Features

* 🔐 **Real and Fake PIN system**  
  * Real PIN gives access to the actual account.  
  * Fake PIN simulates a fake account to protect users under duress (emergency situations).  

* 💰 **Account Balance Check**  
* 💵 **Deposit and Withdraw Money**  
* 📜 **Transaction History Logging**  
* 🧾 **Mini Statement (Last 3 Transactions)**  
* 🛑 **Daily Withdrawal Limit**  
  * Users can only withdraw up to **Rs. 5000 per day** to enforce safe spending.  
* 🔄 **Secure PIN Input** (uses `Console.readPassword()` when supported)  

---

### 🧠 Technologies Used

* 💻 Language: **Java**  
* 👨‍💻 IDE: Any Java-compatible IDE (IntelliJ IDEA, Eclipse, VS Code)  
* ☕ Java Version: Java 8 or higher  

---

### 🗃️ Folder Structure

ATM-Simulator/
│
├── Account.java → Handles account balance, PINs, transactions, and limits
├── ATM.java → Main menu UI and user operations
├── Transaction.java → Stores individual transaction details
├── Main.java → Program entry point and PIN setup
└── README.md → Project documentation

---

### 🔄 How It Works

1. **Run `Main.java`**
2. Set your **real** and **fake** PINs (they must be different).
3. Navigate the **ATM menu**:
   * Choose options like balance check, deposit, withdrawal, transaction history, or mini statement.
4. Enter PIN before each operation:
   * If real PIN ➜ full access.  
   * If fake PIN ➜ simulated interface with no real changes.

---

### 📌 Sample Use Cases

| Scenario              | Behavior                                                  |
|-----------------------|-----------------------------------------------------------|
| Real PIN entered      | Full functionality (deposit, withdraw, view history).     |
| Fake PIN entered      | Shows limited/fake info (e.g., fake balance, dummy msg).  |
| Withdraw > 5000/day   | Rejected with warning.                                    |
| View mini statement   | Shows last 3 transactions only.                           |

---

### 🔐 Security Consideration

This simulation includes a **"Fake PIN" system** — a real-world inspired security feature used in ATMs or mobile wallets to alert or mislead during threats.

---

### ⚠️ Limitations

* No persistent data storage (reset on each run).  
* Console password input may not work in some IDEs (e.g., VS Code terminal). Falls back to visible input.  
* No GUI — purely console-based for simplicity and learning.  

---

### 📌 To Do (Future Enhancements)

* Add **savings goal tracker**  
* Add **family account mode** with children spending limits  
* Integrate with **file storage** or **SQLite** for persistence  
* Create a simple **GUI** using Swing or JavaFX  

---

### 🙌 Acknowledgements

This project was built as part of a learning journey in Java, OOP design, and real-world security concepts. Inspired by practical banking systems.

---

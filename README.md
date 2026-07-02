# 📄 Digital Document Verification System (DDVS)

A Java-based Digital Document Verification System developed using Object-Oriented Programming concepts. The system allows users to upload documents, assign verification officers, track verification status, maintain verification logs, and generate verification reports.

---

## 🚀 Features

- User Registration
- Officer Registration
- Document Upload
- Officer Assignment
- Verification Status Tracking
- Verification Logs
- Verification Report Generation
- Custom Exception Handling

---

## 🛠 Technologies Used

- Java
- Eclipse IDE
- Collections (ArrayList)
- Object-Oriented Programming (OOP)
- Exception Handling
- Git & GitHub

---

## 📂 Project Structure

```
src
│
├── com.wipro.ddvs.entity
│   ├── User.java
│   ├── Officer.java
│   ├── Document.java
│   └── VerificationLog.java
│
├── com.wipro.ddvs.service
│   └── VerificationService.java
│
├── com.wipro.ddvs.util
│   ├── UserNotFoundException.java
│   ├── OfficerNotFoundException.java
│   ├── DocumentNotFoundException.java
│   └── InvalidVerificationException.java
│
└── com.wipro.ddvs.main
    └── Main.java
```

---

## 🔄 Workflow

1. Register User
2. Register Officer
3. Upload Document
4. Assign Officer
5. Add Verification Log
6. Update Verification Status
7. Generate Verification Report

---

## 📋 Verification Status

- PENDING
- UNDER_REVIEW
- VERIFIED
- REJECTED

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/noyalashwin0704-ai/DigitalDocumentVerificationSystem.git
```

2. Open the project in Eclipse IDE.

3. Run:

```
Main.java
```

---

## 📌 Sample Output

```
===== Verification Report =====

Document ID : D001
User ID : U001
File Name : marksheet.pdf
Document Type : Education Proof
Status : VERIFIED
Assigned Officer : O001

Verification Logs
-----------------
Verified marksheet, details match.
```

---

## 👨‍💻 Author

**Noyal Ashwin J**

B.Tech Artificial Intelligence & Data Science

Karpagam College of Engineering

GitHub:
https://github.com/noyalashwin0704-ai

---

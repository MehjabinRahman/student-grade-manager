# Student Grade Manager (Java OOP)

A Java console-based application that manages student academic records using Object-Oriented Programming (OOP) principles.  
The system allows users to add students, calculate grades, determine pass/fail status, store records persistently using files, and analyze overall class performance.

This project is designed as a **clean, beginner-to-intermediate Java OOP project** suitable for GitHub portfolios, resumes, and interviews.

---

## Features

- Add student names and marks
- Automatically determine **Pass / Fail**
- Assign letter grades (**A, B, C, D, F**)
- Save student records persistently using a **CSV file**
- View all saved student records
- Search students by name (partial match supported)
- Sort students by marks (highest to lowest)
- View class statistics:
  - Average mark
  - Pass rate
  - Grade distribution

---

## Grade Evaluation Rules

| Marks Range | Grade | Result |
|------------|-------|--------|
| 85 – 100 | A | Pass |
| 70 – 84 | B | Pass |
| 60 – 69 | C | Pass |
| 50 – 59 | D | Pass |
| Below 50 | F | Fail |

---

## Technologies Used

- **Java**
- Object-Oriented Programming (Encapsulation, Modularity)
- File I/O (BufferedReader / BufferedWriter)
- Java Collections (List, Map)
- Exception Handling
- Console-based User Interface

---

## How to Compile and Run

### Step 1: Compile
From the project root directory:
javac -d out src/*.java
java -cp out Main

### Step 2: Run
java -cp out Main




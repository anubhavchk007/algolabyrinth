# 🧠 AlgoLabyrinth

A backend-driven algorithmic escape room built with Java Spring Boot, MongoDB, and multithreading. Players solve programming puzzles level by level in a gamified coding environment.

---

## Features

- Puzzle-based progression system (Rooms)
- Concurrent submission evaluation using Java `ExecutorService`
- User authentication & submission tracking
- MongoDB for flexible NoSQL schema
- Dockerized: one-command setup
- 🛡Forbidden keywords filter for code submissions

---

## Tech Stack

- **Java 17** (or above)
- **Spring Boot**
- **MongoDB**
- **Multithreading (`ExecutorService`, `ConcurrentHashMap`)**
- **Docker & Docker Compose**

---

## 📸 API Overview

### Submit a solution:
```http
POST /api/submit

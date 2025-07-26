# GitHub API & Web Automation Testing 
# This showcases hands-on automation testing using GitHub's public Web API and browser-based validations via Selenium WebDriver. 

### REST API Testing using Java (GitHub APIs)
-  Verified base URL `https://api.github.com` returns HTTP **200 OK**
-  Checked HTTP status codes (like 200 OK, 401 Unauthorized)
-  Verified API Response Headers and Body
-  Confirmed **Content-Type** is `application/json`
-  Checked **rate limits** for unauthenticated users
-  Validated Authenticated vs Unauthenticated API responses
-  Attempted creating a repository without authentication — received **401 Unauthorized**
-  Retrieved public repositories and extracted data from JSON response
-  Practical Handson on these:
- [x] API base response verification
- [x] Handling unauthenticated requests
- [x] Using correct/incorrect credentials
- [x] Exploring common **HTTP Status Codes**
  - 200 – OK
  - 400 – Bad Request
  - 401 – Unauthorized
  - 404 – Not Found
- [x] Compared REST vs GraphQL workflows
- [x] Designed tests that simulate real API failures and retries  
---

### GraphQL Mutation
-  Understood how GitHub uses **GraphQL** for data mutations
-  Successfully updated GitHub **status message** using GraphQL queries (mutation)
-  Practiced handling response codes and error messages for incorrect payloads or headers
---

## Practical Scenarios Tested

- Counted total public repositories associated with specific GitHub users using REST API
- Created a Calculator program that performs basic operations: Add, Subtract, Multiply, Divide
- Verified if GitHub username matches the associated nickname 
- Checked if GitHub repository URL correctly navigates to the intended repo
- Tested invalid scenarios like:
  - Wrong credentials while creating a repo (Expected: 401 Unauthorized)
  - Invalid endpoints or methods (Expected: 404 Not Found / 400 Bad Request)
- Practiced error handling and status code validation using real GitHub APIs

[Reference for HTTP Status Codes](https://www.webfx.com/web-development/glossary/http-status-codes/)

---

## 🛠️ Tools Used

| Tool           | Purpose                          |
|----------------|----------------------------------|
| Java           | Core programming                 |
| GitHub REST API| Endpoint testing                 |
| GraphQL        | Mutation testing                 |
| Postman        | Manual testing & exploration     |
| IntelliJ       | Code execution                   |

---

###  Updating Status Using GraphQL Mutation
<img width="997" alt="GraphQL Mutation" src="https://github.com/user-attachments/assets/bb5b4837-a035-47c9-a7ba-2652c6bee7af" />

###  Updated Status Verification
<img width="1396" alt="GraphQL Bio Updated" src="https://github.com/user-attachments/assets/b94c214b-1286-457e-b94f-f7e5809f2b29" />

### Calculator API Tests
<img width="1728" height="1060" alt="Calculator Tests" src="https://github.com/user-attachments/assets/b6384228-19f1-4b1f-b193-eab905c9c9ee" />

### Repository Count Validation
<img width="1728" height="1060" alt="Repo Count" src="https://github.com/user-attachments/assets/34956ab0-dba1-4237-b906-b80ccf8e951e" />

### Repository Link Navigation
<img width="1728" height="1060" alt="Repo Link Navigation" src="https://github.com/user-attachments/assets/abcd1234-xyz" />

---

## Web API Response Validations

### Verify Base URL - HTTP 200
<img width="1728" height="1060" alt="Base URL Response" src="https://github.com/user-attachments/assets/ada52c1a-3e0e-4d4c-8c14-96bdff0cec6f" />

### API Header Response Validation
<img width="1728" height="1060" alt="API Header" src="https://github.com/user-attachments/assets/b7dcbf16-408d-4424-b546-3f3cf6679b4f" />

### Unauthorized Repo Creation (401)
<img width="1728" height="1060" alt="401 Error" src="https://github.com/user-attachments/assets/fc86262d-d454-4db2-9377-c1681aaf8847" />

---

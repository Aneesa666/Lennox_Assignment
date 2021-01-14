# SeleniumProject

This repo contains a simple UI test which navigates through sample page(http://automationpractice.com/index.php) to check if page works as expected. Chrome Driver is used to execute the tests.

1. Checks if Login Button is present and tries to login with 2 dummy users.
2. Clicks "Forget Password", tries to submit the request by entering Email ID.
3. Checks if title "Contact us" exists in main page.
4. Check if "Search Icon" exists in main page.

## How to Run

Below are steps to run the project.

1. Clone the repo.
```
git clone https://github.com/Aneesa666/SeleniumProject.git
```

2. Run Test using below commands.
```
mvn clean
mvn install
```

You can get logs from logs folder and HTML reports from reports folder. If any of test fails screenshot will be captured and stored in reports folder.
Demo App for LinkedIn API

Prerequisites
Ensure that you have an application registered in LinkedIn https://www.linkedin.com/my-items/saved-jobs

To start the server:
Open the terminal and run the following command to install dependencies: mvn install
Execute the following command to run the spring-boot server: mvn spring-boot:run
Note: The server will be running on http://localhost:8080/ 

Open The Swagger UI: http://localhost:8080/swagger-ui/index.html 
1. Then open Post: /linkedin/saved-job section
2. In request body set cookie & csrfToken obtain in prerequisites section
3. Hit Execute button

Now, you will see response from API like below in Response body section
{
    "data": [
        {
            "Role": "Vice President - Regulatory Reporting",
            "Company": "Credit Suisse",
            "Location": "Pune (On-site)",
            "Applied": "Application viewed 2yr ago"
        },
        {
            "Role": "VP UI-Angular Lead - Citi Global Wealth",
            "Company": "Citi",
            "Location": "Pune (Hybrid)",
            "Applied": "Applied 2yr ago"
        }
    ],
    "error": null
}

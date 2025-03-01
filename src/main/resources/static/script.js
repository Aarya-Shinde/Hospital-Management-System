   function validatePassword() {
            let password = document.getElementById("password").value;
            let confirmPassword = document.getElementById("cpassword").value;
            let message = document.getElementById("message");

            if (password.length < 6) {
                message.style.color = "red";
                message.innerHTML = "Password must be at least 6 characters";
                return false;
            }

            if (password !== confirmPassword) {
                message.style.color = "red";
                message.innerHTML = "Passwords do not match";
                return false;
            } else {
                message.style.color = "green";
                message.innerHTML = "Passwords match";
                return true;
            }
        }


//1. Fetching Employees (fetchEmployees())
//
//Calls GET /employees API to retrieve employee data.
//Populates an HTML table with employee details.
//Includes a delete button for each employee.
//Adding a New Employee (employeeForm submit event)
//
//2. Captures input values from the form.
//Sends a POST request to add a new employee.
//Refreshes the employee list after successful insertion.
//Deleting an Employee (deleteEmployee(id))
//
//3. Sends a DELETE request to remove an employee.
//Refreshes the employee list.
//Auto-loading Employees on Page Load (DOMContentLoaded)
//
//4. Fetches and displays employees when the page loads.



const API_URL = "/patients"; // API for patient management

// Fetch and display patients
function fetchPatients() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const tableBody = document.getElementById("patientTableBody");
            tableBody.innerHTML = "";
            data.forEach(patient => {
                tableBody.innerHTML += `
                    <tr>
                        <td>${patient.id}</td>
                        <td>${patient.name}</td>
                        <td>${patient.age}</td>
                        <td>${patient.gender}</td>
                        <td>${patient.contact}</td>
                        <td>${patient.disease}</td>
                        <td>${patient.doctor}</td>
                        <td><button class="delete" onclick="deletePatient(${patient.id})">Delete</button></td>
                    </tr>
                `;
            });
        });
}

// Add new patient
document.getElementById("patientForm").addEventListener("submit", function (e) {
    e.preventDefault();
    const patient = {
        name: document.getElementById("name").value,
        age: document.getElementById("age").value,
        gender: document.getElementById("gender").value,
        contact: document.getElementById("contact").value,
        disease: document.getElementById("disease").value,
        doctor: document.getElementById("doctor").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(patient)
    }).then(() => {
        fetchPatients();
        document.getElementById("patientForm").reset();
    });
});

// Delete patient
function deletePatient(id) {
    fetch(`${API_URL}/${id}`, { method: "DELETE" }).then(() => fetchPatients());
}

// Load patients on page load
document.addEventListener("DOMContentLoaded", fetchPatients);

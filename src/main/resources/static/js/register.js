document.getElementById("registerForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    const response = await fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, email, password, role })
    });

    if (response.ok) {
        alert("Registration successful! Please login.");
        window.location.href = "login.html";
    } else {
        const errorData = await response.json();
        alert("Registration failed: " + (errorData.message || "Unknown error"));
    }
});

document.getElementById("login-form").addEventListener("submit", async function(event) {
    event.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password })
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || "Invalid credentials.");
        }

        const data = await response.json();
        localStorage.setItem("userRole", data.role);

        // ✅ Redirect based on role
        window.location.href = `${data.role.toLowerCase()}-dashboard.html`;
    } catch (error) {
        document.getElementById("error-message").textContent = error.message;
    }
});

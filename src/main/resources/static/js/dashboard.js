document.addEventListener("DOMContentLoaded", async function() {
    const token = localStorage.getItem("token");

    if (!token) {
        window.location.href = "login.html"; // Redirect to login if no token
        return;
    }

    const response = await fetch("http://localhost:8080/api/user/me", {
        method: "GET",
        headers: {
            "Authorization": "Bearer " + token,
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const user = await response.json();
        document.getElementById("userName").innerText = user.name;
        document.getElementById("userRole").innerText = user.role;

        if (user.role === "PATIENT") {
            document.getElementById("patientOptions").style.display = "block";
        } else if (user.role === "DOCTOR") {
            document.getElementById("doctorOptions").style.display = "block";
        } else {
            document.getElementById("adminOptions").style.display = "block";
        }
    } else {
        localStorage.removeItem("token");
        window.location.href = "login.html";
    }
});

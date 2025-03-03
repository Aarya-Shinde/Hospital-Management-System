document.addEventListener("DOMContentLoaded", () => {
    const appointmentForm = document.getElementById("appointmentForm");

    if (appointmentForm) {
        appointmentForm.addEventListener("submit", async (event) => {
            event.preventDefault();

            const patientName = document.getElementById("patientName").value;
            const doctorId = document.getElementById("doctorId").value;
            const date = document.getElementById("date").value;

            const response = await fetch("http://localhost:8080/appointments/book", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ patientName, doctorId, date })
            });

            if (response.ok) {
                alert("Appointment booked successfully!");
            } else {
                alert("Failed to book appointment.");
            }
        });
    }
});

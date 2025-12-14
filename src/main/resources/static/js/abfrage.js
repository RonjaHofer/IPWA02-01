document.addEventListener("DOMContentLoaded", function () {
    // Alle Radio-Buttons holen
    const radios = document.querySelectorAll('input[name="radioDefault"]');

    // Eingabegruppen
    const ddWrapper = document.getElementById("ddwrapper");
    const dmsWrapper = document.getElementById("dmswrapper");
    const ddFields = document.querySelectorAll("#ddwrapper input");
    const dmsFields = document.querySelectorAll("#dmswrapper input");

    // Listeners
    radios.forEach(radio => {
        radio.addEventListener('change', () => {
            if (radio.value === "dd") {
              ddWrapper.classList.remove("visually-hidden");
              dmsWrapper.classList.add("visually-hidden");

              ddFields.forEach(f => f.required = true);
              dmsFields.forEach(f => f.required = false);

            } else if (radio.value === "dms") {
              dmsWrapper.classList.remove("visually-hidden");
              ddWrapper.classList.add("visually-hidden");

              dmsFields.forEach(f => f.required = true);
              ddFields.forEach(f => f.required = false);
            }
        });
    });
});
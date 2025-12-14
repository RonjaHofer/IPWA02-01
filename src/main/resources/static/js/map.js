document.addEventListener("DOMContentLoaded", function () {
    // Karte initialisieren
    var map = L.map('map').setView([51.505, -0.09], 5);

    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);

    // Geisternetze hinzufügen
    if (typeof geisternetze !== 'undefined') {

        geisternetze
            .filter(netz => netz.status !== "GEBORGEN") // nur die nicht geborgenen anzeigen
            .forEach(function (netz, index) {

                var lat = Number(netz.breitengrad);
                var lng = Number(netz.laengengrad);

                var marker = L.marker([lat, lng]).addTo(map);

                // Popup mit select zum Statuswechsel
                var popupContent = `
                    <div class="popup-container">

                        <div><b>Breitengrad:</b> ${netz.breitengrad}</div>
                        <div><b>Längengrad:</b> ${netz.laengengrad}</div>
                        <div><b>Größe in Meter:</b> ${netz.geschaetzteGroesse}</div>
                        <div><b>Status:</b> ${netz.status}</div>

                    </div>
                `;
                marker.bindPopup(popupContent);
            });
    };
});
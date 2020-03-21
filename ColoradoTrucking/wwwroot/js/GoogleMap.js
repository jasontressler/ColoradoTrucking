var map;

function initMap() {

    // Initialize map object
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 39, lng: -105.7821 },
        zoom: 6.9, minZoom: 6.9, mapTypeControl: false, streetViewControl: false,
    });

    // Add Markers script to map
    var script = document.createElement('script');
    script.src ='../js/Markers.js';
    document.getElementsByTagName('head')[0].appendChild(script);

    // Set initial boundaries of map
    var bounds = new google.maps.LatLngBounds(
        new google.maps.LatLng(36.998440, -109.045658),
        new google.maps.LatLng(41.002379, -102.051562)
    )

    // Shade everything outside of Colorado //////////////////////////////////////////
        var CoBounds = [
            { lat: 36.998440, lng: -109.045658 },
            { lat: 40.999593, lng: -109.049950 },
            { lat: 41.002379, lng: -102.051562 },
            { lat: 36.992990, lng: -102.041874 }
        ]
        var WorldBounds = [ // covers the (mercator projection) world
            new google.maps.LatLng(85, 180),
            new google.maps.LatLng(85, 90),
            new google.maps.LatLng(85, 0),
            new google.maps.LatLng(85, -90),
            new google.maps.LatLng(85, -180),
            new google.maps.LatLng(0, -180),
            new google.maps.LatLng(-85, -180),
            new google.maps.LatLng(-85, -90),
            new google.maps.LatLng(-85, 0),
            new google.maps.LatLng(-85, 90),
            new google.maps.LatLng(-85, 180),
            new google.maps.LatLng(0, 180),
            new google.maps.LatLng(85, 180)
        ];

        var boundPoly = new google.maps.Polygon({
            paths: [WorldBounds, CoBounds],
            strokeColor: '#FF0000',
            strokeOpacity: .8,
            strokeWeight: 1.5,
            fillOpacity: .3
        });

        boundPoly.setMap(map);
    //////////////////////////////////////////////////////////////////////////////////

    // Don't allow panning outside of Colorado
    map.addListener('dragend', function () {
        if (bounds.contains(map.getCenter())) return;

        var c = map.getCenter(),
            x = c.lng(),
            y = c.lat(),
            maxX = bounds.getNorthEast().lng(),
            maxY = bounds.getNorthEast().lat(),
            minX = bounds.getSouthWest().lng(),
            minY = bounds.getSouthWest().lat();

        if (x < minX) x = minX;
        if (x > maxX) x = maxX;
        if (y < minY) y = minY;
        if (y > maxY) y = maxY;

        map.setCenter(new google.maps.LatLng(y, x));
    });

    var infowindow = new google.maps.InfoWindow();
    window.eqfeed_callback = function (results) {
        for (var i = 0; i < results.features.length; i++) {
            var coords = results.features[i].geometry.coordinates;
            var f = results.features[i].properties;
            var contentString =
                '<p>' + f.name + '</p>' +
                '<p>' + f.city + ', ' + f.state + ' ' + f.zip + '</p>' +
                '<p>' + f.phone + '</p>' +
                '<p>' + f.street + '</p>';
            var latLng = new google.maps.LatLng(coords[0], coords[1]);
            var marker = new google.maps.Marker({
                position: latLng,
                map: map
            });
            bindInfoWindow(marker, map, infowindow, contentString);
            marker.addListener('mouseout', function () {
                infowindow.close();
            });

        }
    }
    function bindInfoWindow(marker, map, infowindow, content) {
        marker.addListener('mouseover', function () {
            infowindow.setContent(content);
            infowindow.open(map, this);
        });
    }
}
var map;
var infowindow;
var markers;

function initMap() {
    markers = [];

    // Initialize map object
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 39, lng: -105.7821 },
        zoom: 6.9, minZoom: 6.9, mapTypeControl: false, streetViewControl: false,
    });

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

    infowindow = new google.maps.InfoWindow({ maxWidth: 300 });
}

function GenerateMarkers(results) {
    //Clear old markers if they exist.
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers = [];

    //Add new markers

    for (var i = 0; i < results.features.length; i++) {
        var coords = results.features[i].geometry.coordinates;
        var f = results.features[i].properties;

        var contentString =
            '<p><b>' + f.inName + '</b></p>' +
            '<p>' + f.inStreet + '<br/>' +
            f.inCity + ', ' + f.inState + ' ' + f.inZip + '</p>' +
            '<p>' + f.inPhone + '</p>';

        if (f.outDOT != null) {
            contentString +=
                '<p><b>' + f.outName + '</b> was at this location <b>' +
            (f.dayDiff < 31 ? f.dayDiff + '</b> days' : (f.dayDiff < 365) ? (f.dayDiff / 31).toFixed(1) + '</b> months' : (f.dayDiff / 365).toFixed(1) + '</b> years') +
                ' before ' + f.inName + ' launched. <br/></p>';

            if (f.flag > 0) {
                contentString += '<p>This is a potential chameleon company.</p>';
            }
                
        }

        var latLng = new google.maps.LatLng(coords[0], coords[1]);

        var marker = new google.maps.Marker({
            position: latLng,
            map: map,
            optimized: false,
            icon: {
                url: getIcon(f.flag)
            }
        });

        bindInfoWindow(marker, map, infowindow, contentString);
        marker.addListener('mouseout', function () {
            infowindow.close();
        });
        markers.push(marker);

    } 
}

//Add mouseover listener to marker
function bindInfoWindow(marker, map, infowindow, content) {
    marker.addListener('mouseover', function () {
        infowindow.setContent(content);
        infowindow.open(map, this);
    });
}

//Get icon image based on feature flag
function getIcon(flag) {

    switch (flag) {
        case 0:
            return '../img/zero-dot.png';
            break;
        case 1:
            return '../img/one-dot.png'; 
            break;
        case 2:
            return '../img/two-dot.png';
            break;
        case 3:
            return '../img/three-dot.png';
            break;
        case 4:
            return '../img/four-dot.png';
            break;
        case 5:
            return '../img/five-dot.png';
            break;
        default:
            return '../img/zero-dot.png';
    }
}
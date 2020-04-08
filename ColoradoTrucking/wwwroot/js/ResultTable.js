var t;

function initTable() {
    $(document).ready(function () {
        t = $('#resultsTable').DataTable({
            "columnDefs": [
                { "width": "10%" },
                { "width": "40%" },
                { "width": "25%" },
                { "width": "10%" },
                { "width": "10%" },
                { "width": "10%" },
                { "width": "10%" }
            ]
        });
    })
}

function popTable(results) {
    t.clear();

    for (var i = 0; i < results.features.length; i++) {
        var f = results.features[i].properties;
        t.row.add([
            f.inDOT,
            f.inName,
            f.inStreet,
            f.inCity,
            f.inPhone,
            (f.outReason == null ? "N/A" : f.outReason),
            f.flag
        ])
    }
    t.draw();
    
}
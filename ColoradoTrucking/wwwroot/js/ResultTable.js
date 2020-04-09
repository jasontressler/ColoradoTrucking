var t;

function initTable() {
    $(document).ready(function () {
        t = $('#resultsTable').DataTable();
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
            (f.outName == null ? "N/A" : f.outName),
            (f.outDate == null ? "N/A" : f.outDate),
            (f.outReason == null ? "N/A" : f.outReason),
            f.flag
        ])
    }
    t.draw();
    
}
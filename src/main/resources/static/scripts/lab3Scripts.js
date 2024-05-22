function checkSolving() {
    let word = document.getElementById("input").value.trim()
    let rq = {
        request: word
    }
    $.ajax({
        type: "POST",
        url: "./lab3/solve",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            document.getElementById("output").innerHTML = data;
            clearGraph()
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}

function clearGraph() {
    $.ajax({
        type: "POST",
        url: "./lab3/clear",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function (data) {
            console.log("Graph cleared")
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}
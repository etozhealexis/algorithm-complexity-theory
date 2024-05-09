function checkSolving() {
    let word = document.getElementById("input").value.trim()
    let rq = {
        request: word
    }
    $.ajax({
        type: "POST",
        url: "./lab5/solve",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            let message = data.message + "<br>" + data.timeExecutionMessage
            document.getElementById("output").innerHTML = message;
            clearSet()
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}

function clearSet() {
    $.ajax({
        type: "POST",
        url: "./lab5/clear",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function (data) {
            console.log("Set cleared")
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}
function checkSolving() {
    let s = document.getElementById("input-s").value.trim()
    let c = document.getElementById("input-c").value.trim()
    let chi = document.getElementById("input-chi").value.trim()
    let rq = {
        s: s,
        c: c,
        chi: chi
    }
    $.ajax({
        type: "POST",
        url: "./lab5/solve",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            document.getElementById("output").innerHTML =
                data.message + "<br>" + data.timeExecutionMessage;
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
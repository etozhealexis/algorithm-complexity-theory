function checkSolving() {
    let word = document.getElementById("input").value.trim()
    let rq = {
        request: word
    }
    $.ajax({
        type: "POST",
        url: "./lab4/solve",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            let message = data.message + "<br>" + data.timeExecutionMessage
            document.getElementById("output").innerHTML = message;
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}
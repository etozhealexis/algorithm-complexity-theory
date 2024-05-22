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
            document.getElementById("output").innerHTML =
                data.message + "<br>" + data.timeExecutionMessage + "<br>" + data.feasibilityMessage;
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}
function checkStateMachineSolving() {
    let word = document.getElementById("smInput").value.trim()
    let rq = {
        request: word
    }
    $.ajax({
        type: "POST",
        url: "./lab1/sm",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            document.getElementById("smOutput").innerHTML = data;
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}

function checkRegexSolving() {
    let word = document.getElementById("regexInput").value.trim()
    let rq = {
        request: word
    }
    $.ajax({
        type: "POST",
        url: "./lab1/regex",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            let message = data;
            document.getElementById("regexOutput").innerHTML = message;
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}
function checkStateMachineSolving() {
    let word = document.getElementById("smInput").value.trim()
    let rq = {
        request: word
    }
    $.ajax({
        type: "POST",
        url: "./lab2/sm",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            document.getElementById("smOutput").innerHTML =
                "<br>" + data.stateHistoryMessage + "<br>" + data.stackElementsMessage + "<br>" + data.message;
            clearStack()
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}

function clearStack() {
    $.ajax({
        type: "POST",
        url: "./lab2/clear",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function (data) {
            console.log("Stack cleared")
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
        url: "./lab2/regex",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            document.getElementById("regexOutput").innerHTML = data;
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}
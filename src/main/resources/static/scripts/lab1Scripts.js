function checkStateMachineSolving() {
    let word = $('#smInput').val()
    let rq = {
        request: word
    }
    $.ajax({
        type: "GET",
        url: "./lab1/sm",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(rq),
        success: function (data) {
            let message = data;

        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}
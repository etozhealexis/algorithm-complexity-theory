window.onload = function () {
    getBoard();
}

function getBoard() {
    $.ajax({
        type: "GET",
        url: "./lab6/board",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function (data) {
            fillBoard(data)
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}

function makeTurn(filedIndex) {
    let turn = {
        request: filedIndex
    }
    $.ajax({
        type: "POST",
        url: "./lab6/turn",
        contentType: "application/json; charset=utf8",
        async: false,
        data: JSON.stringify(turn),
        success: function (data) {
            fillBoard(data)
        },
        error: function () {
            alert("Field is already taken")
        }
    })
    sleep(250).then(checkGameEnd)
}

function checkGameEnd() {
    $.ajax({
        type: "GET",
        url: "./lab6/check-game-end",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function (data) {
            if (data === true) {
                alert("Computer has won. Don't try it :)")
                clearBoard()
            }
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}

function clearBoard() {
    $.ajax({
        type: "POST",
        url: "./lab6/clear",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function () {
            window.location.reload();
        },
        error: function () {
            console.log("Something went wrong!");
        }
    })
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function fillBoard(data) {
    let board = data.board;
    for (let i = 0; i < 11; i++) {
        element = '#' + (i + 1);
        if (board[i] === "X") {
            $(element).css({ 'color': 'red' });
        }
        if (board[i] === "O") {
            $(element).css({ 'color': 'blue' });
        }
        $(element).html(board[i]);
    }
}
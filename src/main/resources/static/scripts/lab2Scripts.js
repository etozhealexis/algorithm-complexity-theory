$(document).ready(function () {
    getBoard();
})

function getBoard() {
    $.ajax({
        type: "GET",
        url: "./lab6/board",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function (data) {
            let board = data.board;
            for (let i = 0; i < 11; i++) {
                element = '#' + (i + 1);
                $(element).html(board[i]);
            }
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
            let board = data.board;
            for (let i = 0; i < 11; i++) {
                element = '#' + (i + 1);
                $(element).html(board[i]);
            }
        },
        error: function () {
            alert("Field is already taken")
        }
    })
    sleep(2);
    checkGameEnd();
}

function checkGameEnd() {
    $.ajax({
        type: "GET",
        url: "./lab6/check-game-end",
        contentType: "application/json; charset=utf8",
        async: false,
        success: function (data) {
            let gameEnd = data;
            if (gameEnd === true) {
                alert("Computer has won. try again")
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
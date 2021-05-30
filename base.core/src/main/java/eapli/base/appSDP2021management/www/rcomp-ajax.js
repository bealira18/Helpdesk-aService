function refreshTarefas() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("tarefas");

    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "black";
        setTimeout(refreshTarefas, 2500);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshTarefas, 200);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshTarefas, 3000);
    };

    request.open("GET", "/votes", true);
    request.timeout = 3000;
    request.send();
}

function showTarefas(idColaborador) {
    var request = new XMLHttpRequest();
    request.open("PUT", "/tarefas/" + idColaborador, true);
    request.send();
    var vBoard = document.getElementById("tarefas");
    vBoard.innerHTML = vBoard.innerHTML + "<p>Casting your vote ... Please wait.";

}


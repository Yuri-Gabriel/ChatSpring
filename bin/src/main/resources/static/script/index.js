const button_start = document.getElementById("button_start");

button_start.addEventListener("click", () => {
    const username = document.getElementById("username_input").value.trim();
    if(username == "") {
        alert("Username is empty");
        return;
    } else if(username.length < 3) {
        alert("Username is small: " + username);
        return;
    }
    
    fetch('/api/saveUser', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username
        })
    })
    .then(response => {
        if(response.status == 201) {
            return response.json();
        }
        throw new Error(response.statusText);
    })
    .then(json => {
        window.sessionStorage.setItem("user", JSON.stringify(json));
        window.location.href = "/chat";
    })
    .catch(error => {
        alert(error.message);
    });
});   
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
    
    fetch('/api/enter_chat', {
        method: "POST",
        headers: {
            "ContentType": "aplication/json"
        },
        body: JSON.stringify({
            username: username
        })
    })
});   
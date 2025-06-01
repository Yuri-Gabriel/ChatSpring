var user_session = null;

const user = sessionStorage.getItem("user");

if(user == null) {
    window.location.href = "/";
} else {
	try {
		user_session = JSON.parse(user);
	} catch (err) {
		window.location.href = "/";
	}
}

window.onload = () => {
    const messageArea = document.getElementById('message_area');
    messageArea.scrollTop = messageArea.scrollHeight;
}

const loadMessages = (messages) => {
	const message_container = document.getElementById("message_area");

	let isThisUser = false;
	let html = "";
	messages.forEach(m => {
		const isThisUser = m.user.id === user_session.id;
		html += 
			`<div class="message_container ${isThisUser ? "this_user_message" : ""}">` +
				'<div class="message_component">' +
					'<div class="username_message">' +
						`<h4>${m.user.username}</h4>` +
					'</div>' +
					'<div class="text_message">' +
						`<label>${m.content}</label>` +
					'</div>' +
				'</div>' +
			'</div>';
	});
	message_container.innerHTML = html;
}

const getAllMessages = () => {
	fetch('/api/getMessages', {
		method: "GET"
	})
	.then(async reponse => {
		if(reponse.status == 200) {
			return reponse.json();
		}
		const errorJson = await response.json();
		throw new Error(errorJson.message || "Erro desconhecido");
	})
	.then(json => {
		loadMessages(json);
	})
	.catch(error => {
		console.log(error.message);
        alert(error.message);
    });
}

const send_message_btn = document.getElementById("send_message_btn");
send_message_btn.addEventListener("click", () => {
	const message = document.getElementById("message_input");
	if(message.value.trim() != "") {
		fetch("/api/saveMessage", {
			method: "POST",
	        headers: {
	            "Content-Type": "application/json"
	        },
	        body: JSON.stringify({
	            user: user_session,
				content: message.value
	        })
		})
		.then(async response => {
	        if(response.status == 201) {
	            getAllMessages();
				message.value = "";
	        } else {
				const errorJson = await response.json();
				throw new Error(errorJson.message || "Erro desconhecido");
			}
			
	    })
	    .catch(error => {
			console.log(error);
	        alert(error);
	    });
	}
	
});

document.addEventListener("DOMContentLoaded", () => {
    getAllMessages();
	
	setInterval(() => {
        getAllMessages();
    }, 1000);
});


//limitar a 500 characteres

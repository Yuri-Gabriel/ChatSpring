var user_session = null;

const user = sessionStorage.getItem("user");

if(user == null) {
    window.location.href = "/";
} else {
    user_session = JSON.parse(user);
}

window.onload = () => {
    const messageArea = document.getElementById('message_area');
    messageArea.scrollTop = messageArea.scrollHeight;
}

//limitar a 500 characteres

/*
<div class="message_container">
    <div class="message_component">
        <div class="username_message">
            <h4>Você</h4>
        </div>
        <div class="text_message">
            <label>
                Esta é uma mensagem enviada por mim.
            </label>
        </div>
    </div>
</div>
<div class="message_container this_user_message">
    <div class="message_component">
        <div class="username_message">
            <h4>Você</h4>
        </div>
        <div class="text_message">
            <label id="pao">
                Lorem ipsum dolor sit amet 
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora repellat a rerum temporibus dolor. Iure hic reiciendis perspiciatis necessitatibus delectus, nesciunt omnis beatae sit est et eum, nam, dignissimos consequuntur.
            </label>
        </div>
    </div>
</div>
*/
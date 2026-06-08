async function enviarDenuncia() {

    const denuncia = {
        telefone: document.getElementById("telefone").value,
        descricao: document.getElementById("descricao").value,
        risco: document.getElementById("risco").value
    };

    const resposta = await fetch(
        "http://localhost:8080/denuncias",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(denuncia)
        }
    );

    if(resposta.ok){
        alert("Denúncia enviada com sucesso!");
    }else{
        alert("Erro ao enviar denúncia");
    }
}


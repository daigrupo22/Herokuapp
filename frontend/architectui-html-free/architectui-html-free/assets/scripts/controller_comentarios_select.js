(async function () {
  console.log("hi");
  const read = await fetch(
    "https://cidadeamiga.herokuapp.com/atividade"
  );
  const data = await read.json();

  /*
  var data = [
    {
      id_atividade: 2,
      nome_atividade: "Inauguração de um parque",
      image:
        "https://www.ikebanaflores.com.br/blog/wp-content/uploads/2018/10/como-fazer-um-pomar-em-casa-a-gente-explica.jpeg",
      data: "21-08-2000",
      descricao:
        "Hoje vamos visitar o zoo. Não percas estes adoraveis animais!",
      estado: true,
      publicado: true,
      idUser: 2342,
      data_fim: "21-09-2000",
      parceiro: "tia ester",
    },
    {
      id_atividade: 1,
      nome_atividade: "Ida ao Oceanário",
      image:
        "https://www.ikebanaflores.com.br/blog/wp-content/uploads/2018/10/como-fazer-um-pomar-em-casa-a-gente-explica.jpeg",
      data: "21-08-2000",
      descricao:
        "Hoje vamos visitar o zoo. Não percas estes adoraveis animais!",
      estado: true,
      publicado: true,
      idUser: 2342,
      data_fim: "21-09-2000",
      parceiro: "tia ester",
    },
    {
      id_atividade: 3,
      nome_atividade: "Ida à Praia",
      image:
        "https://www.ikebanaflores.com.br/blog/wp-content/uploads/2018/10/como-fazer-um-pomar-em-casa-a-gente-explica.jpeg",
      data: "21-08-2000",
      descricao:
        "Hoje vamos visitar o zoo. Não percas estes adoraveis animais!",
      estado: true,
      publicado: true,
      idUser: 2342,
      data_fim: "21-09-2000",
      parceiro: "tia ester",
    },
  ];*/

  var t = "";
  for (const evento of data) {
    t +=
      '<div class="centerbt">' +
      '<button onclick="changepage(' +
      evento.id_atividade +
      ')" style="font-size: 120%;" class="mb-2 mr-2 btn btn-info">' +
      evento.nome_atividade +
      /*"<img src=" +
      evento.image +
      " width='160' height='90'>" +*/
      "</button>" +
      "</div>";
  }
  document.getElementById("eventos").innerHTML = t;
})();

function changepage(n) {
  window.location.href = "comentarios-evento.html";
  window.localStorage.setItem("id_atividade", n);
}

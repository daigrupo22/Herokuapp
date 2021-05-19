(async function () {
  console.log("hi");
  const read = await fetch(
    "https://cidadeamiga.herokuapp.com/tudocomentario"
  );
  const data = await read.json();

  /*var data = [
    {
      id_comentario: 1,
      comentario: "Que fixe, estou a adorar as focas.",
      data: "14-05-2021",
      idComentarioOriginal: null,
      id_crianca: 2342,
      id_atividade: 1,
    },
    {
      id_comentario: 2,
      comentario: "Os leões marinhos são tão giroooos.",
      data: "14-05-2021",
      idComentarioOriginal: null,
      id_crianca: 2342,
      id_atividade: 1,
    },
    {
      id_comentario: 3,
      comentario: ":D",
      data: "14-05-2021",
      idComentarioOriginal: null,
      id_crianca: 2342,
      id_atividade: 2,
    },
    {
      id_comentario: 3,
      comentario: "Vamos a la playa a mi me gusta bailar!",
      data: "14-05-2021",
      idComentarioOriginal: null,
      id_crianca: 2342,
      id_atividade: 3,
    },
  ];*/

  var atividade = window.localStorage.getItem("id_atividade");

  var t = "";
  for (const comentario of data) {
    if (comentario.id_atividade == atividade) {
      t +=
        '<div style="margin-left: 30px;margin-right: 30px;" class="main-card mb-3 card">' +
        '<div class="card-body"><h5 class="card-title">' +
        comentario.id_crianca +
        "</h5>" +
        '<div class="scroll-area-sm">' +
        '<div class="scrollbar-container ps--active-y">' +
        comentario.comentario +
        "</div></div></div></div>";
    }
  }
  document.getElementById("comentarios").innerHTML = t;
})();

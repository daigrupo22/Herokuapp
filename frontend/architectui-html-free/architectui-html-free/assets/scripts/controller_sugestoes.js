(async function () {
  console.log("hi");
  const read = await fetch(
    "https://cidadeamiga.herokuapp.com/tudosugestao"
  );
  const data = await read.json();

  /*var data = [
    {
      id_sugestao: 2,
      data: "11-05-2021",
      sugestao: "Gostava muito de ir a um parque aquático!!!",
      id_crianca: 2351,
    },
    {
      id_sugestao: 1,
      data: "14-05-2021",
      sugestao:
        "Eu acho que deviamos de ir ao zoo. Prefiro animais normais a peixinhos.:-D",
      id_crianca: 2342,
    },
  ];*/

  var t = "";
  for (const sugestao of data) {
    t +=
      '<div style="margin-left: 30px;margin-right: 30px;" class="main-card mb-3 card">' +
      '<div class="card-body"><h5 class="card-title">' +
      sugestao.id_crianca +
      "</h5>" +
      '<div class="scroll-area-sm">' +
      '<div class="scrollbar-container ps--active-y">' +
      sugestao.sugestao +
      "</div></div></div></div>";
  }
  document.getElementById("sugestoes").innerHTML = t;
})();

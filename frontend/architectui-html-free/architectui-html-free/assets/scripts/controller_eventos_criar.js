function registerAtividade() {
  let data = {};
  data.data = document.getElementById("exampleDate").value;
  data.concelho = document.getElementById("exampleRegiao").value;
  data.descricao = document.getElementById("exampleDescription").value;

  //alert(JSON.stringify(data));

  try {
    fetch("https://cidadeamiga.herokuapp.com/inseriratividade", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((data) => alert(data));
  } catch (err) {
    alert(err);
  }
}

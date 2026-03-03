<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kaiser Xit - UI Demo</title>
<style>
body{
    margin:0;
    background:#111;
    font-family:Arial, sans-serif;
    color:white;
    overflow:hidden;
}

.panel{
    position:fixed;
    top:50%;
    left:50%;
    transform:translate(-50%,-50%);
    width:700px;
    background:#1a1a1a;
    padding:20px;
    border-radius:15px;
    box-shadow:0 0 30px black;
}

.title{
    text-align:center;
    font-size:28px;
    margin-bottom:15px;
}

.section{
    margin:15px 0;
}

button{
    padding:8px 15px;
    margin:5px;
    border:none;
    border-radius:8px;
    background:#333;
    color:white;
    cursor:pointer;
}

button.active{
    background:red;
}

input[type=range]{
    width:100%;
}

#fovCircle{
    position:fixed;
    top:50%;
    left:50%;
    transform:translate(-50%,-50%);
    border:2px solid red;
    border-radius:50%;
    display:none;
    pointer-events:none;
}

</style>
</head>
<body>

<div class="panel">
    <div class="title">Kaiser Xit (UI Demo)</div>

    <div class="section">
        <h3>Selecionar Parte</h3>
        <button onclick="selectPart(this)">Cabeça</button>
        <button onclick="selectPart(this)">Pescoço</button>
        <button onclick="selectPart(this)">Peito</button>
    </div>

    <div class="section">
        <h3>FOV</h3>
        <button id="fovBtn" onclick="toggleFov()">FOV OFF</button>
        <br><br>
        FOV Size:
        <input type="range" min="0" max="2000" value="200" id="fovSlider" oninput="updateFov()">
    </div>

    <div class="section">
        <h3>ESP (Visual Demo)</h3>
        <button onclick="toggleActive(this)">ESP Player</button>
        <button onclick="toggleActive(this)">ESP Box</button>
        <button onclick="toggleActive(this)">ESP Linha Cabeça</button>
        <button onclick="toggleActive(this)">ESP Esqueleto</button>
    </div>
</div>

<div id="fovCircle"></div>

<script>
let fovOn = false;
let circle = document.getElementById("fovCircle");
let slider = document.getElementById("fovSlider");
let fovBtn = document.getElementById("fovBtn");

function toggleFov(){
    fovOn = !fovOn;

    if(fovOn){
        circle.style.display = "block";
        fovBtn.innerText = "FOV ON";
        fovBtn.classList.add("active");
    } else {
        circle.style.display = "none";
        fovBtn.innerText = "FOV OFF";
        fovBtn.classList.remove("active");
    }
}

function updateFov(){
    let size = slider.value;
    circle.style.width = size + "px";
    circle.style.height = size + "px";
}

function selectPart(btn){
    let buttons = btn.parentElement.querySelectorAll("button");
    buttons.forEach(b => b.classList.remove("active"));
    btn.classList.add("active");
}

function toggleActive(btn){
    btn.classList.toggle("active");
}
</script>

</body>
</html>

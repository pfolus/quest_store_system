function openContent(evt, contentName) {
    var i, tabcontent;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    document.getElementById(contentName).style.display = "block";
}


function openSubContent(evt, contentName) {
    var i, studentcontent;

    studentcontent = document.getElementsByClassName("subcontent");
    for (i = 0; i < studentcontent.length; i++) {
        studentcontent[i].style.display = "none";
    }

    document.getElementById(contentName).style.display = "block";

}
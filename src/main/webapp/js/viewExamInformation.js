window.onload = function queryLatestExamStudents() {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/LaboratoryManagementSystem/displayUser?_=', true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("examTbody").innerHTML = xhr.responseText;
        } else if (xhr.readyState === 4 && xhr.status !== 200) {
            alert("显示异常，请联系管理员！")
        }
    };
    xhr.send();
}
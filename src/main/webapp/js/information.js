window.addEventListener("DOMContentLoaded",function () {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/LaboratoryManagementSystem/aName?rName=realName", true);
    xhr.onload = function () {
        if (xhr.status === 200) {
            var parts = xhr.responseText.split(',');

            if(parts.length > 6) {
                document.getElementById('realUserName').value = parts[0];
                document.getElementById("realName").value = parts[1];
                document.getElementById("realID").value = parts[2];
                document.getElementById("realSex").value = parts[3];
                document.getElementById("realPhone").value = parts[4];
                document.getElementById("realEmail").value = parts[5];
                document.getElementById("realCollege").value = parts[6];
            }

        } else {
            alert('请求失败');
        }
    };
    xhr.send();
})
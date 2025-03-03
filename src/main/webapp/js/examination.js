window.addEventListener("DOMContentLoaded",function () {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/LaboratoryManagementSystem/examNeed?date=" + new Date().getTime(), true);
    xhr.onload = function () {
        if (xhr.readyState === 4) { // 请求已完成
            if (xhr.status === 200) { // 响应状态码为200，表示成功
                document.getElementById("examNeed").innerHTML = xhr.responseText; // 更新DOM以显示服务器响应
            }
            else {

            }
        }
    };
    xhr.send();
})
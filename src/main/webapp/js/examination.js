window.addEventListener("DOMContentLoaded",function () {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/LaboratoryManagementSystem/examNeed?date=" + new Date().getTime(), true);
    xhr.onload = function () {
        if (xhr.readyState === 4) { // ���������
            if (xhr.status === 200) { // ��Ӧ״̬��Ϊ200����ʾ�ɹ�
                document.getElementById("examNeed").innerHTML = xhr.responseText; // ����DOM����ʾ��������Ӧ
            }
            else {

            }
        }
    };
    xhr.send();
})
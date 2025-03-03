// 页面加载时显示最新考试时间的考生信息
// 查询最新考试时间的考生信息
window.onload = function queryLatestExamStudents() {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/LaboratoryManagementSystem/displayApp?_=', true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("examTbody").innerHTML = xhr.responseText;

            document.querySelectorAll('input[id^="results_"]').forEach(input => {
                input.addEventListener('blur', function() {
                    const rowNumber = this.id.split('_')[1]; // 从 id 中提取行号
                    updateScore(rowNumber);
                });
            });
        } else if (xhr.readyState === 4 && xhr.status !== 200) {
            alert("显示异常，请联系管理员！")
        }
    };
    xhr.send();
}

// 更新成绩
 function updateScore(rowNumber) {
    const xhr = new XMLHttpRequest();

     const thExamId = document.getElementById('thExamId_' + rowNumber).textContent;
     const thId = document.getElementById('thId_' + rowNumber).textContent;
     const results = document.getElementById('results_' + rowNumber).value;

     xhr.open('POST', '/LaboratoryManagementSystem/update?thExamId=' + thExamId + '&thId=' + thId + '&results=' + results, true);
     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     xhr.onreadystatechange = function() {
         if (xhr.readyState === 4 && xhr.status !== 200) {
             alert("显示异常，请联系管理员！");
         }
    };
    xhr.send()
}

// 查询学生信息
function queryStudents() {
    const search = document.getElementById("search").value;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/LaboratoryManagementSystem/searchApp?search=' + search, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("examTbody").innerHTML = xhr.responseText;

            document.querySelectorAll('input[id^="results_"]').forEach(input => {
                input.addEventListener('blur', function() {
                    const rowNumber = this.id.split('_')[1]; // 从 id 中提取行号
                    updateScore(rowNumber);
                });
            });
        } else if (xhr.readyState === 4 && xhr.status !== 200) {
            alert("显示异常，请联系管理员！");
        }
    };
    xhr.send();
}

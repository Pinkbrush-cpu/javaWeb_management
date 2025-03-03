//
// document.getElementById('registerForm').addEventListener('submit', function(event) {
//     const name = document.getElementById('name').value;
//     const username = document.getElementById('username').value;
//     const password = document.getElementById('password').value;
//     const studentId = document.getElementById('studentId').value;
//     const phonenumber = document.getElementById('phonenumber').value;
//     const email = document.getElementById('email').value;
//
//
//
//     // 检查用户名是否为空或太短
//     if (username.trim() === '' || username.length < 6) {
//         errorMessage += '用户名不能为空且长度不能少于6个字符。<br>';
//     }
//
//     // 检查电子邮件格式
//     const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
//     if (!emailPattern.test(email)) {
//         errorMessage += '请输入有效的电子邮件地址。<br>';
//     }
//
//     // 检查密码是否满足复杂性要求（例如，至少8个字符，包含字母和数字）
//     const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
//     if (!passwordPattern.test(password)) {
//         errorMessage += '密码必须至少8个字符长，包含字母和数字。<br>';
//     }
//     const encryptedPassword = btoa(password);
//     // 显示错误信息（如果有）
//     if (errorMessage !== '') {
//         document.getElementById('errorMessage').innerHTML = errorMessage;
//         event.preventDefault(); // 阻止表单提交
//     } else {
//         // 如果没有错误信息，可以执行进一步的操作，如发送数据到服务器
//         // 例如：document.getElementById('registerForm').submit(); // 但由于我们已经在这里拦截了提交，所以不会再次调用它
//         console.log('表单验证通过，可以发送数据到服务器。');
//     }
// });

window.onload = function() {
    document.getElementById("inputName").addEventListener("blur", function() {
        var name = document.getElementById("inputName").value;

        var xhr = new XMLHttpRequest()  // 更清晰的变量命名
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) { // 请求已完成
                if (xhr.status === 200) { // 响应状态码为200，表示成功

                    document.getElementById("nameDiv").innerHTML = xhr.responseText; // 更新DOM以显示服务器响应
                }
                else {

                }
            }
        }


        xhr.open("POST", "/LaboratoryManagementSystem/ajaxName?_=" + new Date().getTime(), true)

        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("name=" + name)


    })

    document.getElementById("inputUsername").addEventListener("blur", function() {
        var username = document.getElementById("inputUsername").value;

        var xhr1 = new XMLHttpRequest()  // 更清晰的变量命名
        xhr1.onreadystatechange = function() {
            if (xhr1.readyState === 4) { // 请求已完成
                if (xhr1.status === 200) { // 响应状态码为200，表示成功

                    document.getElementById("usernameDiv").innerHTML = xhr1.responseText; // 更新DOM以显示服务器响应
                }
                else {

                }
            }
        }


        xhr1.open("POST", "/LaboratoryManagementSystem/ajaxUsername?_=" + new Date().getTime(), true)

        xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr1.send("username=" + username)


    })

    document.getElementById("inputPassword").addEventListener("blur", function() {
        var password = document.getElementById("inputPassword").value;

        var xhr2 = new XMLHttpRequest()  // 更清晰的变量命名
        xhr2.onreadystatechange = function() {
            if (xhr2.readyState === 4) { // 请求已完成
                if (xhr2.status === 200) { // 响应状态码为200，表示成功

                    document.getElementById("passwordDiv").innerHTML = xhr2.responseText; // 更新DOM以显示服务器响应
                }
                else {

                }
            }
        }


        xhr2.open("POST", "/LaboratoryManagementSystem/ajaxPassword?_=" + new Date().getTime(), true)

        xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr2.send("password=" + password)


    })

    document.getElementById("inputSex").addEventListener("blur", function() {
        var sex = document.getElementById("inputSex").value;

        var xhr3 = new XMLHttpRequest()  // 更清晰的变量命名
        xhr3.onreadystatechange = function() {
            if (xhr3.readyState === 4) { // 请求已完成
                if (xhr3.status === 200) { // 响应状态码为200，表示成功

                    document.getElementById("sexDiv").innerHTML = xhr3.responseText; // 更新DOM以显示服务器响应
                }
                else {

                }
            }
        }


        xhr3.open("POST", "/LaboratoryManagementSystem/ajaxSex?_=" + new Date().getTime(), true)

        xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr3.send("sex=" + sex)


    })

    document.getElementById("inputPhonenumber").addEventListener("blur", function() {
        var phonenumber = document.getElementById("inputPhonenumber").value;

        var xhr4 = new XMLHttpRequest()  // 更清晰的变量命名
        xhr4.onreadystatechange = function() {
            if (xhr4.readyState === 4) { // 请求已完成
                if (xhr4.status === 200) { // 响应状态码为200，表示成功

                    document.getElementById("phonenumberDiv").innerHTML = xhr4.responseText; // 更新DOM以显示服务器响应
                }
                else {

                }
            }
        }


        xhr4.open("POST", "/LaboratoryManagementSystem/ajaxPhonenumber?_=" + new Date().getTime(), true)

        xhr4.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr4.send("phonenumber=" + phonenumber)


    })

    document.getElementById("inputEmail").addEventListener("blur", function() {
        var email = document.getElementById("inputEmail").value;

        var xhr5 = new XMLHttpRequest()  // 更清晰的变量命名
        xhr5.onreadystatechange = function() {
            if (xhr5.readyState === 4) { // 请求已完成
                if (xhr5.status === 200) { // 响应状态码为200，表示成功

                    document.getElementById("emailDiv").innerHTML = xhr5.responseText; // 更新DOM以显示服务器响应
                }
                else {

                }
            }
        }


        xhr5.open("POST", "/LaboratoryManagementSystem/ajaxEmail?_=" + new Date().getTime(), true)

        xhr5.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr5.send("email=" + email)


    })
}

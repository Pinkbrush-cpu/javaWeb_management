document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('登录成功！'); // 这里可以替换为实际的登录逻辑
});

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const regUsername = document.getElementById('regUsername').value;
    const regPassword = document.getElementById('regPassword').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (regPassword !== confirmPassword) {
        alert('两次输入的密码不一致！');
    } else {
        alert('注册成功！'); // 这里可以替换为实际的注册逻辑
    }
});

document.getElementById('forgotPasswordForm').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('重置链接已发送到你的邮箱！'); // 这里可以替换为实际的忘记密码逻辑
});
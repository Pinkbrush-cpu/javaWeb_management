const loginForm = document.getElementById('login-form');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');
const usernameError = document.getElementById('username-error');
const passwordError = document.getElementById('password-error');
const generalError = document.getElementById('general-error');

loginForm.addEventListener('submit', (event) => {
    event.preventDefault(); // 阻止表单默认提交

    // 清除之前的错误提示
    usernameError.textContent = '';
    passwordError.textContent = '';
    generalError.textContent = '';
    usernameError.style.display = 'none';
    passwordError.style.display = 'none';
    generalError.style.display = 'none';

    // 获取用户名和密码
    const username = usernameInput.value.trim();
    const password = passwordInput.value.trim();

    // 验证用户名和密码
    if (username === '') {
        usernameError.textContent = '请输入账号';
        usernameError.style.display = 'block';
        return;
    }
    if (password === '') {
        passwordError.textContent = '请输入密码';
        passwordError.style.display = 'block';
        return;
    }

    // 模拟登录验证
    if (username === 'admin' && password === '123456') {
        // 登录成功，跳转到其他页面
        window.location.href = 'welcome.html'; // 替换为实际的欢迎页面地址
    } else {
        // 登录失败，显示错误提示
        generalError.textContent = '账号或密码错误';
        generalError.style.display = 'block';
    }
});
NSERT INTO cms_database.insurance_entity (insurance_type, insurance_amount)
VALUES 
    ('CAR_INSURANCE', 100000),
    ('HOME_INSURANCE', 200000),
    ('LIFE_INSURANCE', 500000);


INSERT INTO cms_database.admin (id, password)
VALUES (1, '12345');








login.html


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>Login</title>
</head>
<body>
    <header>
        <h2 class="logo">CMS</h2>
        <nav class="navigation">
            <a href="welcome.html">Back</a>
        </nav>
    </header>

    <div class="wrapper">
        <form id="loginForm">
            <h1>Login</h1>
            <div class="input-box">
                <input type="text" id="username" placeholder="Username" required />
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="password" id="password" placeholder="Password" required />
                <i class='bx bxs-lock-alt'></i>
            </div>
            <div class="remember-forgot">
                <label><input type="checkbox"/>Remember Me</label>
                <a href="#">Forgot Password?</a>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>
    </div>

    <script src="login.js"></script>
</body>
</html>


















login.js





document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally
    
    // Get username and password from input fields
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    
    // Prepare the request body
    var requestBody = {
        "adminId": username,
        "password": password
    };
    
    // Make a POST request to the API
    fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
    .then(response => response.json())
    .then(data => {
        // Check if response is true
        if (data === true) {
            // Redirect to dashboard.html
            window.location.href = 'dashboard.html';
        } else {
            alert('Login failed. Please check your credentials.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while logging in.');
    });
});
